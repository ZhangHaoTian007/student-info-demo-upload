package com.demo.persitence;

import com.demo.domain.LessonSelected;
import com.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 32050
 */
public interface StudentRepository extends JpaRepository<Student, String> {
    /**
     * 通过学号academicCode返回学生信息
     * @param academicCode 学号
     * @return 学生信息
     */
    Student findStudentByAcademicCode(String academicCode);
}
