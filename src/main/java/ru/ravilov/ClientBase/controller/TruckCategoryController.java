package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ravilov.ClientBase.model.TruckCategory;
import ru.ravilov.ClientBase.service.TruckCategoryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class TruckCategoryController {


    private TruckCategoryService truckCategoryService;

    @Autowired
    public TruckCategoryController(TruckCategoryService truckCategoryService) {
        this.truckCategoryService = truckCategoryService;
    }

    @GetMapping("/truckCategories")
    public String truckCategoriesMethod(Model model){

        List<TruckCategory> truckCategoryList = truckCategoryService.listAll();
        model.addAttribute("truckCategoryList",truckCategoryList);
        return "truck_categories";

    }

    @GetMapping("/truckCategory/{id}")
    public String getTruckCategoryInfo(@PathVariable Long id, Model model){

        TruckCategory truckCategory = truckCategoryService.get(id);
        model.addAttribute("truckCategory",truckCategory);

        return "truck_category";
    }

    @GetMapping("/newTruckCategory")
    public String createNewTruckCategory(Model model){

        TruckCategory truckCategory = new TruckCategory();
        model.addAttribute("truckCategory",truckCategory);

        return "new_truck_category";
    }

    @PostMapping("/saveTruckCategory")
    public String saveTruckCategory(@ModelAttribute("truckCategory") TruckCategory truckCategory, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        truckCategory.setImage(fileName);
        TruckCategory saveTruckCategory = truckCategoryService.save(truckCategory);

        String uploadDir = "/brand-logos/" + saveTruckCategory.getId();

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
        return "redirect:/truckCategories";
    }
}
