package lv.trainingapp.training.controller;


import lv.trainingapp.training.model.ParticipantModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParticipantController {


    @GetMapping("/apply") //end-point
    public String addParticipant(Model model) {
        model.addAttribute("participant", new ParticipantModel());
        return "registration"; //html page
    }
}

