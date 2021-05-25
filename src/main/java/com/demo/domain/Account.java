package com.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 32050
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String username;
    private String password;
    /**
     * 角色类型ID：学生（1）、教师（2）、管理员（0）
     */
    private int roleNumber;
    private String rolePrimaryKey;
}
