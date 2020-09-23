package com.fzm.employees_management.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;
    private String email;
    private Department department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Employee(Integer id,String name,Integer gender,String email,Department department){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.department = department;
        this.birthday = new Date();
    }

}
