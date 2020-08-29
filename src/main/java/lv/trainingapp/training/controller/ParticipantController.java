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

    //counts booked classes from registration:
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("counthtml", "" + htmlCourse.size());
        model.addAttribute("countjavascript","" + javaScriptCourse.size());
        model.addAttribute("countjava","" + javaCourse.size());
        model.addAttribute("countcsharp","" + cSharpCourse.size());
        model.addAttribute("countphp","" + phpCourse.size());
        return "index";
    }
    //html class register:
    @GetMapping("/applyhtml")
    public String addParticipant1(Model model) {
        model.addAttribute("html", new ParticipantModel());
        return "reghtml";
    }
    //after press button Apply:
    @PostMapping("/addstudenthtml")
    public String addStudentHtmlCourse(@ModelAttribute ParticipantModel participantModel, Model model) {
        model.addAttribute("html",participantModel);

        if ((htmlCourse.size()) < 2) {
            htmlCourse.add(participantModel);
            try {
                makeList1(htmlCourse);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regsuccessful";
        } else {
            htmlWaiting.add(participantModel);
            try {
                waitingList1(htmlWaiting);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "regfull";
        }
    }
    //JavaScript training:
    List<ParticipantModel> javaScriptCourse = new ArrayList<>();
    List<ParticipantModel> javaScriptWaiting = new ArrayList<>();

    @GetMapping("/applyjavascript")
    public String addParticipant2(Model model) {
        model.addAttribute("javascript", new ParticipantModel());
        return "regjavascript";
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
    //save participant data to .txt file:
    public static void makeList1(List<ParticipantModel> htmlCourse) throws FileNotFoundException {

        System.out.println("Participant added to training list");
        String line = "";
        for(ParticipantModel participant : htmlCourse){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("htmllist.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeList2(List<ParticipantModel> javaScriptCourse) throws FileNotFoundException {

        System.out.println("Participant added to training list");
        String line = "";
        for(ParticipantModel participant : javaScriptCourse){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("javascriptlist.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeList3(List<ParticipantModel> javaCourse) throws FileNotFoundException {

        System.out.println("Participant added to training list");
        String line = "";
        for(ParticipantModel participant : javaCourse){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("javalist.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeList4(List<ParticipantModel> cSharpCourse) throws FileNotFoundException {

        System.out.println("Participant added to training list");
        String line = "";
        for (ParticipantModel participant : cSharpCourse) {
            line = participant.toString() + "\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("csharplist.txt", true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeList5(List<ParticipantModel> phpCourse) throws FileNotFoundException {

        System.out.println("Participant added to training list");
        String line = "";
        for (ParticipantModel participant : phpCourse) {
            line = participant.toString() + "\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("phplist.txt", true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //create waiting lists .txt file:
    public static void waitingList1(List<ParticipantModel> htmlWaiting) throws FileNotFoundException {

        System.out.println("Participant added to waiting list");
        String line = "";
        for(ParticipantModel participant : htmlWaiting){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("htmlwaiting.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitingList2(List<ParticipantModel> javaScriptWaiting) throws FileNotFoundException {

        System.out.println("Participant added to waiting list");
        String line = "";
        for(ParticipantModel participant : javaScriptWaiting){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("javascriptwaiting.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitingList3(List<ParticipantModel> javaWaiting) throws FileNotFoundException {

        System.out.println("Participant added to waiting list");
        String line = "";
        for(ParticipantModel participant : javaWaiting){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("javawaiting.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitingList4(List<ParticipantModel> cSharpWaiting) throws FileNotFoundException {

        System.out.println("Participant added to waiting list");
        String line = "";
        for(ParticipantModel participant : cSharpWaiting){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("csharpwaiting.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitingList5(List<ParticipantModel> phpWaiting) throws FileNotFoundException {

        System.out.println("Participant added to waiting list");
        String line = "";
        for(ParticipantModel participant : phpWaiting){
            line = participant.toString()+"\n";
        }
        try {
            FileOutputStream list = new FileOutputStream("phpwaiting.txt",true);
            String inputData = line;
            byte[] byteArray = inputData.getBytes();
            list.write(byteArray);
            list.flush();
            list.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

