package lv.trainingapp.training.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DescriptionController {

    @GetMapping("/csharp")
    public String homePage1(Model model) {
        return "infocsharp";
    }

    @GetMapping("/htmlcss")
    public String homePage2(Model model) {
        return "infohtmlcss";
    }

    @GetMapping("/java")
    public String homePage3(Model model) {
        return "infojava";
    }

    @GetMapping("/javascript")
    public String homePage4(Model model) {
        return "infojavascript";
    }

    @GetMapping("/php")
    public String homePage5(Model model) {
        return "infophp";
    }


}
