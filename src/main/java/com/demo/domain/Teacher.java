package com.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Teacher {

    @Id
    private String code;
    private String name;
    private String gender;
    private String phoneNumber;
    private String department;
}
