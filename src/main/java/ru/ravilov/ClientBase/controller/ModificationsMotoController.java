package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.ModificationMoto;
import ru.ravilov.ClientBase.service.ModificationsMotoService;
import ru.ravilov.ClientBase.service.MotoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ModificationsMotoController {
    private ModificationsMotoService modificationsMotoService;
    private MotoService motoService;
    @Autowired
    public ModificationsMotoController(ModificationsMotoService modificationsMotoService, MotoService motoService) {
        this.modificationsMotoService = modificationsMotoService;
        this.motoService = motoService;
    }

    @GetMapping("/allModifyMoto")
    public String viewAllModifyMoto(Model model, HttpServletRequest request){

        List<ModificationMoto> modificationMotoList = modificationsMotoService.listAll();
        model.addAttribute("modifyList", modificationMotoList);

        return "modify_moto";
    }

    @GetMapping("/newModifyMoto")
    public String showNewModifyMotoForm(Model model){
        ModificationMoto modificationMoto = new ModificationMoto();
        model.addAttribute("modificationsMoto", modificationMoto);
        model.addAttribute("moto",motoService.listAll());

        return "new_modify_moto";
    }

    @PostMapping("/saveModifyMoto")
    public String saveModifyMoto(@ModelAttribute("modifyMoto") ModificationMoto modificationMoto) {

        ModificationMoto saveModifyMoto = modificationsMotoService.save(modificationMoto);

        return "redirect:/";
    }

    @GetMapping("/editModifyMoto/{id}")
    public ModelAndView showEditModifyMotoForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_modify_moto");

        ModificationMoto modificationMoto = modificationsMotoService.get(id);
        mav.addObject("modifyMoto", modificationMoto);
        return mav;
    }

    @GetMapping("/showModifyMoto/{id}")
    public String showModifyMoto(Model model, @PathVariable Long id){

        ModificationMoto modifyMoto = modificationsMotoService.get(id);

        model.addAttribute("modifyMoto",modifyMoto);

        return "modifyMotoInfo";
    }

    @GetMapping("/deleteModifyMoto/{id}")
    public String deleteModifyMoto(@PathVariable(name = "id") Long id){
        modificationsMotoService.delete(id);

        return "redirect:/allModifyMoto";
    }
}
