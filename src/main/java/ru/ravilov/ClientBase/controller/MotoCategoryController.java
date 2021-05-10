package ru.ravilov.ClientBase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ravilov.ClientBase.model.MotorcycleCategory;
import ru.ravilov.ClientBase.service.MotoCategoryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class MotoCategoryController {


    private MotoCategoryService motoCategoryService;

    @Autowired
    public MotoCategoryController(MotoCategoryService motoCategoryService) {
        this.motoCategoryService = motoCategoryService;
    }

    @GetMapping("/motoCategories")
    public String motoCategoriesMethod(Model model){

        List<MotorcycleCategory> motorcycleCategoryList = motoCategoryService.listAll();
        model.addAttribute("motorcycleCategoryList",motorcycleCategoryList);
        return "categories";

    }

    @GetMapping("/motoCategory/{id}")
    public String getMotoCategoryInfo(@PathVariable Long id, Model model){

        MotorcycleCategory motorcycleCategory = motoCategoryService.get(id);
        model.addAttribute("motorcycleCategory",motorcycleCategory);

        return "category";
    }

    @GetMapping("/newMotoCategory")
    public String createNewBrandCategory(Model model){

        MotorcycleCategory motorcycleCategory = new MotorcycleCategory();

        model.addAttribute("motorcycleCategory",motorcycleCategory);

        return "new_category";
    }

    @PostMapping("/saveMotoCategory")
    public String saveCategory(@ModelAttribute("motoCategory") MotorcycleCategory motorcycleCategory, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        motorcycleCategory.setImage(fileName);
        MotorcycleCategory saveMotoCategory = motoCategoryService.save(motorcycleCategory);

        String uploadDir = "/brand-logos/" + saveMotoCategory.getId();

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
