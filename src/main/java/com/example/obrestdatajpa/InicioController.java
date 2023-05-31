package com.example.obrestdatajpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InicioController {

    /*
    @GetMapping("/registro")
    public String login(){
        return "registro";
    }
     */

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute(model);
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
