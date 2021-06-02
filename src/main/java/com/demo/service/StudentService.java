package com.demo.service;

import com.demo.domain.Student;
import com.demo.persitence.StudentRepository;

/**
 * @author 32050
 */
public interface StudentService {

    /**
     * 根据主码code获取学生信息
     * @param code 学生主码
     * @return 返回学生信息，如果查找不到，则返回null
     */
    Student getStudentByCode(String code);



}
