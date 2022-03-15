package com.techdenovo.apps.studentmanagementthymeleaf.repository;

import com.techdenovo.apps.studentmanagementthymeleaf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);
    List<Student> findByCollegeName(String name);
}
