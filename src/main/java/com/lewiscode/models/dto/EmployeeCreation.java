package com.lewiscode.models.dto;

import com.lewiscode.models.Department;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeCreation {



    @NotNull(message = "Name cannot be null")
    @Min(value = 5, message = "Name should be at least 5 characters")
    @Column(name="name")
    private String name;


    @NotNull(message = "Email cannot be null")
    @Column(name="email")
    private String email;

    private int department;

    public EmployeeCreation(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
