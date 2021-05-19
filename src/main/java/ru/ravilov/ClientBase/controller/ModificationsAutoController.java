package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.ModificationAuto;
import ru.ravilov.ClientBase.service.*;

import javax.servlet.http.HttpServletRequest;
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

        List<ModificationAuto> modificationAutoList = modificationsAutoService.listAll();
        model.addAttribute("modifyList", modificationAutoList);

        return "modify_auto";
    }

    @GetMapping("/newModifyAuto")
    public String showNewModifyAutoForm(Model model){
        ModificationAuto modificationAuto = new ModificationAuto();
        model.addAttribute("modificationsAuto", modificationAuto);
        model.addAttribute("car",carService.listAll());

        return "new_modify_auto";
    }

    @PostMapping("/saveModifyAuto")
    public String saveModifyAuto(@ModelAttribute("modifyAuto") ModificationAuto modificationAuto) {

        ModificationAuto saveModifyAuto = modificationsAutoService.save(modificationAuto);

        return "redirect:/";
    }

    @GetMapping("/editModifyAuto/{id}")
    public ModelAndView showEditModifyAutoForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_modify_auto");

        ModificationAuto modificationAuto = modificationsAutoService.get(id);
        mav.addObject("modifyAuto", modificationAuto);
        return mav;
    }

    @GetMapping("/showModifyAuto/{id}")
    public String showModifyAuto(Model model, @PathVariable Long id){

        ModificationAuto modifyAuto = modificationsAutoService.get(id);

        model.addAttribute("modifyAuto",modifyAuto);

        return "modifyInfo";
    }

    @GetMapping("/deleteModifyAuto/{id}")
    public String deleteModifyAuto(@PathVariable(name = "id") Long id){
        modificationsAutoService.delete(id);

        return "redirect:/allModifyAuto";
    }
}
