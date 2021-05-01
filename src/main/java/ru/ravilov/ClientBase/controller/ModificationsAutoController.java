package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.FileUploadUtil;
import ru.ravilov.ClientBase.model.ModificationsAuto;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ModificationsAutoController {

    private ModificationsAutoService modificationsAutoService;
    private CarService carService;
    @Autowired
    public ModificationsAutoController(ModificationsAutoService modificationsAutoService, CarService carService) {
        this.modificationsAutoService = modificationsAutoService;
        this.carService = carService;
    }

    @GetMapping("/allModifyAuto")
    public String viewAllModifyAuto(Model model, HttpServletRequest request){

        List<ModificationsAuto> modificationsAutoList = modificationsAutoService.listAll();
        model.addAttribute("modifyList",modificationsAutoList);

        return "modify_auto";
    }

    @GetMapping("/newModifyAuto")
    public String showNewModifyAutoForm(Model model){
        ModificationsAuto modificationsAuto = new ModificationsAuto();
        model.addAttribute("modificationsAuto",modificationsAuto);
        model.addAttribute("car",carService.listAll());

        return "new_modify_auto";
    }

    @PostMapping("/saveModifyAuto")
    public String saveModifyAuto(@ModelAttribute("modifyAuto") ModificationsAuto modificationsAuto) {

        ModificationsAuto saveModifyAuto = modificationsAutoService.save(modificationsAuto);

        return "redirect:/allModifyAuto";
    }

    @GetMapping("/editModifyAuto/{id}")
    public ModelAndView showEditModifyAutoForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_modify_auto");

        ModificationsAuto modificationsAuto = modificationsAutoService.get(id);
        mav.addObject("modifyAuto",modificationsAuto);
        return mav;
    }

    @GetMapping("/showModifyAuto/{id}")
    public String showModifyAuto(Model model, @PathVariable Long id){

        ModificationsAuto modifyAuto = modificationsAutoService.get(id);

        model.addAttribute("modifyAuto",modifyAuto);

        return "modifyInfo";
    }

    @GetMapping("/deleteModifyAuto/{id}")
    public String deleteModifyAuto(@PathVariable(name = "id") Long id){
        modificationsAutoService.delete(id);

        return "redirect:/allModifyAuto";
    }
}
