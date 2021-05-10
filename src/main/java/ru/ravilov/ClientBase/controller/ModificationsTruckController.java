package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.ModificationTruck;
import ru.ravilov.ClientBase.service.ModificationsTruckService;
import ru.ravilov.ClientBase.service.TruckService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ModificationsTruckController {

    private ModificationsTruckService modificationsTruckService;
    private TruckService truckService;
    @Autowired
    public ModificationsTruckController(ModificationsTruckService modificationsTruckService, TruckService truckService) {
        this.modificationsTruckService = modificationsTruckService;
        this.truckService = truckService;
    }

    @GetMapping("/allModifyTruck")
    public String viewAllModifyTruck(Model model, HttpServletRequest request){

        List<ModificationTruck> modificationsMotoList = modificationsTruckService.listAll();
        model.addAttribute("modifyList",modificationsMotoList);

        return "modify_truck";
    }

    @GetMapping("/newModifyTruck")
    public String showNewModifyTruckForm(Model model){
        ModificationTruck modificationTruck = new ModificationTruck();
        model.addAttribute("modificationsTruck", modificationTruck);
        model.addAttribute("truck",truckService.listAll());

        return "new_modify_truck";
    }

    @PostMapping("/saveModifyTruck")
    public String saveModifyTruck(@ModelAttribute("modifyTruck") ModificationTruck modificationsMoto) {

        ModificationTruck saveModifyMoto = modificationsTruckService.save(modificationsMoto);

        return "redirect:/allModifyTruck";
    }

    @GetMapping("/editModifyTruck/{id}")
    public ModelAndView showEditModifyTruckForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_modify_truck");

        ModificationTruck modificationTruck = modificationsTruckService.get(id);
        mav.addObject("modifyTruck", modificationTruck);
        return mav;
    }

    @GetMapping("/showModifyTruck/{id}")
    public String showModifyTruck(Model model, @PathVariable Long id){

        ModificationTruck modifyTruck = modificationsTruckService.get(id);

        model.addAttribute("modifyTruck",modifyTruck);

        return "modifyTruckInfo";
    }

    @GetMapping("/deleteModifyTruck/{id}")
    public String deleteModifyTruck(@PathVariable(name = "id") Long id){
        modificationsTruckService.delete(id);

        return "redirect:/allModifyTruck";
    }
}

