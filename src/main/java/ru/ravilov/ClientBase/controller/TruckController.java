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
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.service.SegmentService;
import ru.ravilov.ClientBase.service.TruckCategoryService;
import ru.ravilov.ClientBase.service.TruckService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
public class TruckController {

    private TruckService truckService;
    private TruckCategoryService truckCategoryService;
    private SegmentService segmentService;
    @Autowired
    public TruckController(TruckService truckService, TruckCategoryService truckCategoryService, SegmentService segmentService) {
        this.truckService = truckService;
        this.truckCategoryService = truckCategoryService;
        this.segmentService = segmentService;
    }

    @GetMapping("/allTrucks")
    public String viewAllTrucks(Model model, HttpServletRequest request){

        List<Truck> truckList = truckService.listAll();
        model.addAttribute("truckList",truckList);

        return "trucks";
    }

    @GetMapping("/newTruck")
    public String showNewTruckForm(Model model){
       Truck truck = new Truck();
        model.addAttribute("truck",truck);
        model.addAttribute("truckCategories",truckCategoryService.listAll());
        model.addAttribute("segment",segmentService.listAll());

        return "new_truck";
    }

    @PostMapping("/saveTruck")
    public String saveTruck(@ModelAttribute("trucks") Truck truck, @RequestParam("fileImage") MultipartFile[] multipartFiles) throws IOException {

        int count = 0;
        for (MultipartFile multipartFile : multipartFiles){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            if(count == 0)
            {
                truck.setImage(fileName);
            }
            if(count == 1) {
                truck.setImage2(fileName);
            }
            if(count == 2) {
                truck.setImage3(fileName);
            }
            count++;

        }
        Truck saveTruck = truckService.save(truck);

        String uploadDir = "/brand-logos/" + saveTruck.getId();

        //Path uploadPath = Paths.get(uploadDir);

        for(MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/truckList";
    }

    @GetMapping("/editTruck/{id}")
    public ModelAndView showEditTruckForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_brand");

        Truck truck = truckService.get(id);
        mav.addObject("truck",truck);
        return mav;
    }

    @GetMapping("/showTruck/{id}")
    public String showTruck(Model model, @PathVariable Long id){

        Truck truck = truckService.get(id);

        model.addAttribute("truck",truck);

        return "TruckInfo";
    }

    @GetMapping("/deleteTruck/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        truckService.delete(id);

        return "redirect:/allTrucks";
    }

}
