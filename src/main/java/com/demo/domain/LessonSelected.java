package com.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 32050
 */
@Data
@Entity
public class LessonSelected {

    @Id
    @GeneratedValue
    private String code;

    private String courseCode;
    private String academicCode;
    private Integer grade;
    private String department;
    private String description;
    private String degreeLevel;
}
