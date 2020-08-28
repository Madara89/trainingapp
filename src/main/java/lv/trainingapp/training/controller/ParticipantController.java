package lv.trainingapp.training.controller;

import lv.trainingapp.training.model.ParticipantModel;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

    //list of registered participants:
    List<ParticipantModel> htmlCourse = new ArrayList<>();

    //waitinglist:
    List<ParticipantModel> htmlWaiting = new ArrayList<>();


    //html register:
    @GetMapping("/applyhtml") //end-point for each training class
    public String addParticipant1(Model model) {
        model.addAttribute("html", new ParticipantModel());
        return "reghtml"; //html page registration
    }
    //after press button Apply:
    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("html",participantModel);

        if ((htmlCourse.size()) < 3) { //count from 0
            htmlCourse.add(participantModel); //pie .add info saglabā course listā
            System.out.println(participantModel.toString());
            return "regsuccessful";
        } else {
            htmlWaiting.add(participantModel); //pie .add info saglabā waiting listā
            System.out.println("Waiting list: " + participantModel.toString());
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

    //save participant data to .txt file:
    public static void makeList(ParticipantModel participantModel) throws FileNotFoundException {

        try {
            FileOutputStream out = new FileOutputStream("list.txt");
            String inputData = participantModel.toString();
            byte[] byteArray = inputData.getBytes();
            out.write(byteArray);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

