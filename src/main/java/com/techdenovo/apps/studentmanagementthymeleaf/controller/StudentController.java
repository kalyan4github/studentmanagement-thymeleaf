package com.techdenovo.apps.studentmanagementthymeleaf.controller;

import com.techdenovo.apps.studentmanagementthymeleaf.model.Student;
import com.techdenovo.apps.studentmanagementthymeleaf.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findbyname")
    public List<Student> getStudentsByName(@RequestParam String name){
        return studentService.getStudentsByName(name);
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
