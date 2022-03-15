package com.techdenovo.apps.studentmanagementthymeleaf.sevice;

import com.techdenovo.apps.studentmanagementthymeleaf.model.Student;
import com.techdenovo.apps.studentmanagementthymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByName(String name){
        return studentRepository.findByFirstName(name);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
}
