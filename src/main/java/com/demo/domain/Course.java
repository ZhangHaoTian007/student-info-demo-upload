package com.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    private String code;
    private String name;
    private String teacher;
    private Integer credit;
    private Integer period;

}
