package ru.ravilov.ClientBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ravilov.ClientBase.model.User;
import ru.ravilov.ClientBase.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/showUserList")
    public String showUserLiseMethod(Model model){
        List<User> userList = userService.listAll();
        model.addAttribute("userList",userList);

        return "userListPage";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){

        userService.delete(id);

        return "redirect:/showUserList";
    }

}
