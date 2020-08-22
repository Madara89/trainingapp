package lv.trainingapp.training.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomePageController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "index";
    }

}


