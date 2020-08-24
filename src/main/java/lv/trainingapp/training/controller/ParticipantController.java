package lv.trainingapp.training.controller;


import lv.trainingapp.training.model.ParticipantModel;
import lv.trainingapp.training.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

//list

    List<Student> htmlCourse = new ArrayList<>();


    @GetMapping("/applyhtml") //end-point for each training class
    public String addParticipant1() {
        //model.addAttribute("participant", new ParticipantModel());
        return "htmlreg"; //html page
    }

    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute Student student, Model model) {
        model.addAttribute("studenthtml", student);
        htmlCourse.add(student);
        return "index";
    }
}

