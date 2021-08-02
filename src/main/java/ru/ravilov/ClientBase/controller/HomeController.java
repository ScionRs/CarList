package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ravilov.ClientBase.model.CarCategory;
import ru.ravilov.ClientBase.model.Segment;
import ru.ravilov.ClientBase.service.CarCategoryService;
import ru.ravilov.ClientBase.service.SegmentService;

import java.util.List;

@Controller
public class HomeController {

    private SegmentService segmentService;
    private CarCategoryService carCategoryService;

    @Autowired
    public HomeController(SegmentService segmentService, CarCategoryService carCategoryService) {
        this.segmentService = segmentService;
        this.carCategoryService = carCategoryService;
    }



    @GetMapping("/")
    public String AllSegment(Model model){

        List<Segment> segmentList = segmentService.listAll();
        List<CarCategory> carCategoryList = carCategoryService.listAll();
        model.addAttribute("carCategoryList",carCategoryList);
        model.addAttribute("segmentList",segmentList);
        return "index";
    }
}
