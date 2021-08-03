package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.Car;
import ru.ravilov.ClientBase.model.FileUploadUtil;
import ru.ravilov.ClientBase.model.Generation;
import ru.ravilov.ClientBase.service.CarService;
import ru.ravilov.ClientBase.service.GenerationService;
import ru.ravilov.ClientBase.service.MotoService;
import ru.ravilov.ClientBase.service.TruckService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class GenerationController {

    private GenerationService generationService;
    private MotoService motoService;
    private CarService carService;
    private TruckService truckService;

    @Autowired
    public GenerationController(GenerationService generationService, MotoService motoService, CarService carService, TruckService truckService) {
        this.generationService = generationService;
        this.motoService = motoService;
        this.carService = carService;
        this.truckService = truckService;
    }


    @GetMapping("/generations")
    public String viewHomePage(Model model, HttpServletRequest request){


        List<Generation> generationList = generationService.listAll();
        model.addAttribute("generationList",generationList);

        return "generations";
    }

    @GetMapping("/newGeneration")
    public String showNewCarProductForm(Model model){
        Generation generation = new Generation();
        model.addAttribute("generation",generation);
        model.addAttribute("motoList",motoService.listAll());
        model.addAttribute("carList",carService.listAll());
        model.addAttribute("truckList",truckService.listAll());

        return "new_generation";
    }

    @PostMapping("/saveGeneration")
    public String saveProduct(@ModelAttribute("generation") Generation generation, @RequestParam("fileImage") MultipartFile[] multipartFiles) throws IOException {

        int count = 0;
        for (MultipartFile multipartFile : multipartFiles){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            if(count == 0)
            {
                generation.setImage(fileName);
            }
            if(count == 1) {
                generation.setImage2(fileName);
            }
            if(count == 2) {
                generation.setImage3(fileName);
            }
            count++;

        }
        Generation saveGeneration = generationService.save(generation);

        String uploadDir = "/brand-logos/" + saveGeneration.getId();

        //Path uploadPath = Paths.get(uploadDir);

        for(MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/";
    }


    @GetMapping("/generation/{id}")
    public String showGeneration(Model model, @PathVariable Long id){

        Generation generation = generationService.get(id);

        model.addAttribute("generationList",generation);

        return "GenerationInfo";
    }

    @GetMapping("/deleteGeneration/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        generationService.delete(id);

        return "redirect:/";
    }

}
