package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ravilov.ClientBase.model.CarCategory;
import ru.ravilov.ClientBase.model.MotorcycleCategory;
import ru.ravilov.ClientBase.model.Segment;
import ru.ravilov.ClientBase.model.TruckCategory;
import ru.ravilov.ClientBase.service.*;

import java.util.List;

@Controller
public class HomeController {

    private SegmentService segmentService;
    private CarCategoryService carCategoryService;
    private MotoCategoryService motoCategoryService;
    private TruckCategoryService truckCategoryService;

    @Autowired
    public HomeController(SegmentService segmentService, CarCategoryService carCategoryService, MotoCategoryService motoCategoryService, TruckCategoryService truckCategoryService) {
        this.segmentService = segmentService;
        this.carCategoryService = carCategoryService;
        this.motoCategoryService = motoCategoryService;
        this.truckCategoryService = truckCategoryService;
    }





    @GetMapping("/")
    public String AllSegment(Model model){

        List<Segment> segmentList = segmentService.listAll();
        List<MotorcycleCategory> motorcycleCategoryList = motoCategoryService.listAll();
        List<CarCategory> carCategoryList = carCategoryService.listAll();
        List<TruckCategory> truckCategoryList = truckCategoryService.listAll();
        model.addAttribute("truckCategoryList",truckCategoryList);
        model.addAttribute("motorcycleCategoryList",motorcycleCategoryList);
        model.addAttribute("carCategoryList",carCategoryList);
        model.addAttribute("segmentList",segmentList);
        return "index";
    }
}
