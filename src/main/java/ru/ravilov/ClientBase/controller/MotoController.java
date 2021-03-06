package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.ravilov.ClientBase.model.FileUploadUtil;
import ru.ravilov.ClientBase.model.Motorcycle;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MotoController {

    private MotoService motoService;
    private MotoCategoryService motoCategoryService;
    private ModificationsMotoService modificationsMotoService;
    @Autowired
    public MotoController(MotoService motoService, MotoCategoryService motoCategoryService, ModificationsMotoService modificationsMotoService) {
        this.motoService = motoService;
        this.motoCategoryService = motoCategoryService;
        this.modificationsMotoService = modificationsMotoService;
    }



    @GetMapping("/allMoto")
    public String viewAllMoto(Model model, HttpServletRequest request){

        List<Motorcycle> motoList = motoService.listAll();
        model.addAttribute("motoList",motoList);
        model.addAttribute("motoModifications",modificationsMotoService);
        return "motos";
    }

    @GetMapping("/newMoto")
    public String showNewMotoForm(Model model){
        Motorcycle moto = new Motorcycle();
        model.addAttribute("moto",moto);
        model.addAttribute("motoCategories",motoCategoryService.listAll());

        return "new_moto";
    }

    @PostMapping("/saveMoto")
    public String saveMoto(@ModelAttribute("moto") Motorcycle moto, @RequestParam("fileImage") MultipartFile[] multipartFiles) throws IOException {

        int count = 0;
        for (MultipartFile multipartFile : multipartFiles){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            if(count == 0)
            {
                moto.setImage(fileName);
            }
            if(count == 1) {
                moto.setImage2(fileName);
            }
            if(count == 2) {
                moto.setImage3(fileName);
            }
            count++;

        }
        Motorcycle saveMoto = motoService.save(moto);

        String uploadDir = "/brand-logos/" + saveMoto.getId();

        //Path uploadPath = Paths.get(uploadDir);

        for(MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/allMoto";
    }

    @GetMapping("/editMoto/{id}")
    public ModelAndView showEditMotoForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_moto");

        Motorcycle moto = motoService.get(id);
        mav.addObject("moto",moto);
        return mav;
    }

    @GetMapping("/showMoto/{id}")
    public String showMoto(Model model, @PathVariable Long id){

        Motorcycle moto = motoService.get(id);

        model.addAttribute("moto",moto);

        return "motoInfo";
    }

    @GetMapping("/deleteMoto/{id}")
    public String deleteMoto(@PathVariable(name = "id") Long id){
        motoService.delete(id);

        return "redirect:/allMoto";
    }

}
