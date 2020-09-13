package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ravilov.ClientBase.model.Brand;
import ru.ravilov.ClientBase.model.BrandCategory;
import ru.ravilov.ClientBase.service.BrandCategoryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class BrandCategoryController {

    @Autowired
    BrandCategoryService brandCategoryService;

    @GetMapping("/categories")
    public String CategoriesMethod(Model model){

        List<BrandCategory> brandCategoryList = brandCategoryService.listAll();
        model.addAttribute("brandCategoryList",brandCategoryList);
        return "categories";

    }

    @GetMapping("/category/{id}")
    public String getCategoryInfo(@PathVariable Integer id,Model model){

        BrandCategory brandCategory = brandCategoryService.get(id);

        model.addAttribute("brandCategory",brandCategory);

        return "category";
    }

    @GetMapping("/newCategory")
    public String createNewBrandCategory(Model model){

        BrandCategory brandCategory = new BrandCategory();

        model.addAttribute("brandCategory",brandCategory);

        return "new_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("brandCategory") BrandCategory brandCategory,@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        BrandCategory brandSave = brandCategoryService.save(brandCategory);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        brandCategory.setImage(fileName);
        BrandCategory saveBrandCategory = brandCategoryService.save(brandCategory);

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
