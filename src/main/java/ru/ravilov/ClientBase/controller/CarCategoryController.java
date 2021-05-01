package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ravilov.ClientBase.model.CarCategory;
import ru.ravilov.ClientBase.model.VehicleType;
import ru.ravilov.ClientBase.service.CarCategoryService;
import ru.ravilov.ClientBase.service.VehicleTypeService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class CarCategoryController {


    private CarCategoryService carCategoryService;
    private VehicleTypeService vehicleTypeService;
    @Autowired
    public CarCategoryController(CarCategoryService carCategoryService, VehicleTypeService vehicleTypeService) {
        this.carCategoryService = carCategoryService;
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/carCategories")
    public String CategoriesMethod(Model model){

        List<CarCategory> carCategoryList = carCategoryService.listAll();
        model.addAttribute("brandCategoryList",carCategoryList);
        return "categories";

    }

    @GetMapping("/carCategory/{id}")
    public String getCategoryInfo(@PathVariable Integer id,Model model){

        CarCategory carCategory = carCategoryService.get(id);
        model.addAttribute("vehicleType",vehicleTypeService.listAll());
        model.addAttribute("brandCategory",carCategory);

        return "category";
    }

    @GetMapping("/newCarCategory")
    public String createNewBrandCategory(Model model){

        CarCategory carCategory = new CarCategory();

        model.addAttribute("brandCategory",carCategory);

        return "new_category";
    }

    @PostMapping("/saveCarCategory")
    public String saveCategory(@ModelAttribute("brandCategory") CarCategory carCategory,@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        CarCategory carSave = carCategoryService.save(carCategory);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        carCategory.setImage(fileName);
        CarCategory saveBrandCategory = carCategoryService.save(carCategory);

        String uploadDir = "/brand-logos/" + saveBrandCategory.getId();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file: " + fileName);
        }
        return "redirect:/categories";
    }
}
