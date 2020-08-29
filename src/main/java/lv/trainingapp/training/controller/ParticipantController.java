package lv.trainingapp.training.controller;

import lv.trainingapp.training.model.ParticipantModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController  {

    //HTML & CSS training:
    List<ParticipantModel> htmlCourse = new ArrayList<>();
    List<ParticipantModel> htmlWaiting = new ArrayList<>();

    //html class register:
    @GetMapping("/applyhtml") //end-point for each training class
    public String addParticipant1(Model model) {
        model.addAttribute("html", new ParticipantModel());
        return "reghtml"; //html page registration
    }
    //after press button Apply:
    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("html",participantModel);

            return "regfull";
        }
    }
    //JavaScript training:
    List<ParticipantModel> javaScriptCourse = new ArrayList<>();
    List<ParticipantModel> javaScriptWaiting = new ArrayList<>();

    @GetMapping("/applyjavascript") //end-point for each training class
    public String addParticipant2(Model model) {
        model.addAttribute("javascript", new ParticipantModel());
        return "regjavascript"; //html page
    }
    //after press button Apply:
    @PostMapping("/addstudentjavascript")
    public String addStudentJavaScriptCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("javascript",participantModel);

        if ((javaScriptCourse.size()) < 2) {
            javaScriptCourse.add(participantModel);
            try {
                makeList2(javaScriptCourse);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regsuccessful";
        } else {
            javaScriptWaiting.add(participantModel);
            try {
                waitingList2(javaScriptWaiting);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regfull";
        }
    }
    //Java training:
    List<ParticipantModel> javaCourse = new ArrayList<>();
    List<ParticipantModel> javaWaiting = new ArrayList<>();

    //javascript class register:
    @GetMapping("/applyjava")
    public String addParticipant3(Model model) {
        model.addAttribute("java", new ParticipantModel());
        return "regjava";
    }
    //after press button Apply:
    @PostMapping("/addstudentjava")
    public String addStudentJavaCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("java",participantModel);

        if ((javaCourse.size()) < 2) {
            javaCourse.add(participantModel);
            try {
                makeList3(javaCourse);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regsuccessful";
        } else {
            javaWaiting.add(participantModel);
            try {
                waitingList3(javaWaiting);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regfull";
        }
    }
    //C# training:
    List<ParticipantModel> cSharpCourse = new ArrayList<>();
    List<ParticipantModel> cSharpWaiting = new ArrayList<>();

    //C# class register:
    @GetMapping("/applycsharp")
    public String addParticipant4(Model model) {
        model.addAttribute("csharp", new ParticipantModel());
        return "regcsharp";
    }
    //after press button Apply:
    @PostMapping("/addstudentcsharp")
    public String addStudentCSharpCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("csharp",participantModel);

        if ((cSharpCourse.size()) < 2) {
            cSharpCourse.add(participantModel);
            try {
                makeList4(cSharpCourse);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regsuccessful";
        } else {
            cSharpWaiting.add(participantModel);
            try {
                waitingList4(cSharpWaiting);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regfull";
        }
    }
    //PHP training:
    List<ParticipantModel> phpCourse = new ArrayList<>();
    List<ParticipantModel> phpWaiting = new ArrayList<>();

    //C# class register:
    @GetMapping("/applyphp")
    public String addParticipant5(Model model) {
        model.addAttribute("php", new ParticipantModel());
        return "regphp";
    }
    //after press button Apply:
    @PostMapping("/addstudentphp")
    public String addStudentPhpCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("php",participantModel);

        if ((phpCourse.size()) < 2) {
            phpCourse.add(participantModel);
            try {
                makeList5(phpCourse);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regsuccessful";
        } else {
            phpWaiting.add(participantModel);
            try {
                waitingList5(phpWaiting);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regfull";
        }
    }
}

