package lv.trainingapp.training.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DescriptionController {

    @GetMapping("/csharp")
    public String homePage1(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "infocsharp";
    }
    @GetMapping("/htmlcss")
    public String homePage2(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "infohtmlcss";
    }
    @GetMapping("/java")
    public String homePage3(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "infojava";
    }
    @GetMapping("/javascript")
    public String homePage4(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "infojavascript";
    }
    @GetMapping("/php")
    public String homePage5(Model model) {
        model.addAttribute("message", "Welcome to home page!");
        return "infophp";
    }



}
