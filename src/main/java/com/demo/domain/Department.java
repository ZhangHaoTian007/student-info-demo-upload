package com.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 32050
 */
@Data
@Entity
public class Department {
    @Id
    private String code;
    private String name;
    private String address;
    private String phoneNumber;
}
