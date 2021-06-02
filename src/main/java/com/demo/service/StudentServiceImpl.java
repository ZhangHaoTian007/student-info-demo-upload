package com.demo.service;

import com.demo.domain.Student;
import com.demo.persitence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 32050
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentByCode(String code) {
        return studentRepository.findStudentByAcademicCode(code);
    }
}
