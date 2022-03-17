package com.techdenovo.apps.studentmanagementthymeleaf.sevice;

import com.techdenovo.apps.studentmanagementthymeleaf.model.Student;
import com.techdenovo.apps.studentmanagementthymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public List<Student> getStudentsByName(String name){
        return studentRepository.findByFirstName(name);
    }

    public List<Student> getStudentsByCollege(String name){
        return studentRepository.findByCollegeName(name);
    }

    public Student createOrUpdateStudent(Student student){
        if(student.getId()==null) {
            return studentRepository.save(student);
        }else {
            Optional<Student> studentOptional = studentRepository.findById(student.getId());
            if (studentOptional!=null){
                Student student1 = studentOptional.get();
                student1.setFirstName(student.getFirstName());
                student1.setCollegeName(student.getCollegeName());
                student1 = studentRepository.save(student1);
                return student1;
            }else {
                student = studentRepository.save(student);
                return student;
            }
        }
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
