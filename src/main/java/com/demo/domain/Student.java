package com.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author 32050
 */
@Data
@Entity
public class Student {
    private String name;
    private String gender;
    @Id
    private String academicCode;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private Date birthday;
    private String auxiliaryDepartment;
    private String majorDepartment;
    private String degreeLevel;
    private Integer credit;
    private String dorm;
    private String grade;
    private String address;
}

