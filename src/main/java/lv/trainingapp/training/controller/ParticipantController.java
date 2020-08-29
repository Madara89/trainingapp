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

    //list of registered participants:

    List<ParticipantModel> htmlCourse = new ArrayList<>();

    List<ParticipantModel> htmlWaiting = new ArrayList<>();


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("counthtml", "" + htmlCourse.size());
        return "index";
    }

    //html register:
    @GetMapping("/applyhtml") //end-point for each training class
    public String addParticipant1(Model model) {
        model.addAttribute("html", new ParticipantModel());
        return "reghtml"; //html page
    }
    //after press button Apply:
    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        //int idCount = 0; //test
        model.addAttribute("html",participantModel);
        System.out.println("Getting name" + participantModel.getFirstName());

//        if (participantModel.getFirstName().equals("")){
//            System.out.println("Please fill in all fields"); // paziņojums
//        }

        if ((htmlCourse.size()) < 2) {
            htmlCourse.add(participantModel);
            System.out.println(participantModel.toString());
            return "regsuccessful";
        } else {
            htmlWaiting.add(participantModel);
            System.out.println("Waiting list: "+ participantModel.toString());
            return "regfull";
        }
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

}

