package lv.trainingapp.training.controller;


import lv.trainingapp.training.model.ParticipantModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

//list

    List<ParticipantModel> htmlCourse = new ArrayList<>();


    //html
    @GetMapping("/applyhtml") //end-point for each training class
    public String addParticipant1(Model model) {
        model.addAttribute("html", new ParticipantModel());
        return "reghtml"; //html page
    }
    //puch button Apply:
    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        //int idCount = 0; //test
        model.addAttribute("html",participantModel);
        htmlCourse.add(participantModel);
        //System.out.println(htmlCourse);
        getStudentCount(htmlCourse);


        if ((htmlCourse.size() + 1) < 3) {
            System.out.println("You have registered for class!");
        } else {
            System.out.println("No more free places available for this class.");
            htmlCourse.remove(participantModel); // counter stops
        }
        return "index";
    }

    //javascript
    @GetMapping("/applyjavascript") //end-point for each training class
    public String addParticipant2(Model model) {
        model.addAttribute("javascript", new ParticipantModel());
        return "regjavascript"; //html page
    }

    @PostMapping("/addstudentjavascript")
    public String addStudentJavaScriptCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("javascript",participantModel);
        htmlCourse.add(participantModel);
        //System.out.println(htmlCourse);

        return "index";
    }
    //javas
    @GetMapping("/applyjava") //end-point for each training class
    public String addParticipant3(Model model) {
        model.addAttribute("java", new ParticipantModel());
        return "regjava"; //html page
    }

    @PostMapping("/addstudentjava")
    public String addStudentJavaCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("java",participantModel);
        htmlCourse.add(participantModel);
        System.out.println(htmlCourse);
        return "index";
    }
    //C#
    @GetMapping("/applycsharp") //end-point for each training class
    public String addParticipant4(Model model) {
        model.addAttribute("csharp", new ParticipantModel());
        return "regcsharp"; //html page
    }

    @PostMapping("/addstudentcsharp")
    public String addStudentCSharpCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("csharp",participantModel);
        htmlCourse.add(participantModel);
        System.out.println(htmlCourse);
        return "index";
    }
    //php
    @GetMapping("/applyphp") //end-point for each training class
    public String addParticipant5(Model model) {
        model.addAttribute("php", new ParticipantModel());
        return "regphp"; //html page
    }

    @PostMapping("/addstudentphp")
    public String addStudentPhpCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("php",participantModel);
        htmlCourse.add(participantModel);
        System.out.println(htmlCourse);
        return "index";
    }

    public static void getStudentCount(List<ParticipantModel> listArr){ //how many have applied
        System.out.println(listArr.size()+ "student count");
    }
}

