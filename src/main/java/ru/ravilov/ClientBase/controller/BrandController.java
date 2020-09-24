package ru.ravilov.ClientBase.controller;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.Brand;
import ru.ravilov.ClientBase.model.BrandCategory;
import ru.ravilov.ClientBase.model.FileUploadUtil;
import ru.ravilov.ClientBase.service.BrandCategoryService;
import ru.ravilov.ClientBase.service.BrandService;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class BrandController {



    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandCategoryService brandCategoryService;
    
    @GetMapping("/")
    public String viewHomePage(Model model, HttpServletRequest request, @Param("keyword") String keyword){

        //List<Brand> brandList = brandService.listAll();
        List<Brand> brandList = brandService.listAll(keyword);
        model.addAttribute("brandList",brandList);
        model.addAttribute("keyword", keyword);



        Locale currentLocale = request.getLocale();
        String countryCode = currentLocale.getCountry();
        String countyName = currentLocale.getDisplayCountry();

        String langCode = currentLocale.getLanguage();
        String langName = currentLocale.getDisplayLanguage();

        System.out.println(countryCode + ": " + countyName);
        System.out.println(langCode + ": " + langName);

       /* System.out.println("======");
        String[] languages = Locale.getISOLanguages();

        for (String language: languages){
            Locale locale = new Locale(language);
            System.out.println(language + ":" + locale.getDisplayLanguage());
        }*/
        return "index";
    }

    @GetMapping("/new")
    public String showNewCarProductForm(Model model){
        Brand brands = new Brand();
        model.addAttribute("brands",brands);
        model.addAttribute("categories",brandCategoryService.listAll());

        return "new_brand";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)
   /* @PostMapping("/save")
    public String saveProduct(@ModelAttribute("brands") Brand brands,@RequestParam("fileImage") MultipartFile multipartFile,@RequestParam("extraImage") MultipartFile[] extraMultipartFiles) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        brands.setImage(fileName);

        Brand saveBrand = brandService.save(brands);

        String uploadDir = "/brand-logos/" + saveBrand.getId();

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

        for (MultipartFile extraMultipart : extraMultipartFiles){
            String extraImageName = StringUtils.cleanPath(extraMultipart.getOriginalFilename());
            brands.setImage2(extraImageName);
            brands.setImage3(extraImageName);

            try (InputStream inputStream2 = multipartFile.getInputStream()) {
                Path filePath2 = uploadPath.resolve(extraImageName);
                Files.copy(inputStream2, filePath2, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new IOException("Could not save uploaded file: " + extraImageName);
            }
        }

        return "redirect:/";
    } */

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("brands") Brand brands,@RequestParam("fileImage") MultipartFile[] multipartFiles) throws IOException {

        int count = 0;
      for (MultipartFile multipartFile : multipartFiles){
          String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
          if(count == 0)
          {
              brands.setImage(fileName);
          }
          if(count == 1) {
              brands.setImage2(fileName);
          }
          if(count == 2) {
              brands.setImage3(fileName);
          }
          count++;


          /*if (!Files.exists(uploadPath)) {
              Files.createDirectories(uploadPath);
          }
          try (InputStream inputStream = multipartFile.getInputStream()) {
              Path filePath = uploadPath.resolve(fileName);
              Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
              throw new IOException("Could not save uploaded file: " + fileName);
          }*/

      }
        Brand saveBrand = brandService.save(brands);

        String uploadDir = "/brand-logos/" + saveBrand.getId();

        //Path uploadPath = Paths.get(uploadDir);

        for(MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Integer id){
        ModelAndView mav = new ModelAndView("edit_brand");

       Brand brand = brandService.get(id);
        mav.addObject("brand",brand);
        return mav;
    }

    @GetMapping("/show/{id}")
    public String showCar(Model model, @PathVariable Integer id){

      Brand brands = brandService.get(id);

      model.addAttribute("brands",brands);

      return "CarInfo";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id){
        brandService.delete(id);

        return "redirect:/";
    }
}
