package com.techdenovo.apps.studentmanagementthymeleaf.controller;

import com.techdenovo.apps.studentmanagementthymeleaf.model.Student;
import com.techdenovo.apps.studentmanagementthymeleaf.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());

        return "list-student";
    }
    @GetMapping("/add")
    public String showAddStudentForm(@ModelAttribute Student student){
        return "add-student";
    }

    @PostMapping("/add")
    public String createStudent(@ModelAttribute Student student){
        studentService.createOrUpdateStudent(student);
        return "redirect:/students/";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }
    @PostMapping("edit/{id}")
    public String UpdateStudent(@PathVariable("id") long id, Student student, Model model) {
       studentService.createOrUpdateStudent(student);
            return "redirect:/students/";
    }
}
