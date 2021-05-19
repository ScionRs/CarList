package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.Car;
import ru.ravilov.ClientBase.model.FileUploadUtil;
import ru.ravilov.ClientBase.service.CarCategoryService;
import ru.ravilov.ClientBase.service.CarService;
import ru.ravilov.ClientBase.service.ModificationsAutoService;
import ru.ravilov.ClientBase.service.SegmentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
public class CarController {

    private CarService carService;
    private CarCategoryService carCategoryService;
    private SegmentService segmentService;
    private ModificationsAutoService modificationsAutoService;
    @Autowired
    public CarController(CarService carService, CarCategoryService carCategoryService, SegmentService segmentService, ModificationsAutoService modificationsAutoService) {
        this.carService = carService;
        this.carCategoryService = carCategoryService;
        this.segmentService = segmentService;
        this.modificationsAutoService = modificationsAutoService;
    }



    @GetMapping("/cars")
    public String viewHomePage(Model model, HttpServletRequest request){


        List<Car> carList = carService.listAll();
        model.addAttribute("carList",carList);
        model.addAttribute("carModifications",modificationsAutoService);


        return "cars";
    }

    @GetMapping("/newCar")
    public String showNewCarProductForm(Model model){
        Car car = new Car();
        model.addAttribute("car",car);
        model.addAttribute("carCategories",carCategoryService.listAll());
        model.addAttribute("segments",segmentService.listAll());

        return "new_car";
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

    @PostMapping("/saveCar")
    public String saveProduct(@ModelAttribute("car") Car car,@RequestParam("fileImage") MultipartFile[] multipartFiles) throws IOException {

        int count = 0;
      for (MultipartFile multipartFile : multipartFiles){
          String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
          if(count == 0)
          {
              car.setImage(fileName);
          }
          if(count == 1) {
              car.setImage2(fileName);
          }
          if(count == 2) {
              car.setImage3(fileName);
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
        Car saveCar = carService.save(car);

        String uploadDir = "/brand-logos/" + saveCar.getId();

        //Path uploadPath = Paths.get(uploadDir);

        for(MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/cars";
    }

    @GetMapping("/editCar/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_brand");

       Car car = carService.get(id);
        mav.addObject("car",car);
        return mav;
    }

    @GetMapping("/showCar/{id}")
    public String showCar(Model model, @PathVariable Long id){

      Car car = carService.get(id);

      model.addAttribute("car",car);

      return "CarInfo";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        carService.delete(id);

        return "redirect:/";
    }
}
