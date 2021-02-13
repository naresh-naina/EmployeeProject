package com.example.demo.employee.dataModel;

import java.util.Date;
import java.util.List;

public class Employee {

    private Integer id;

    private String name;

    private Date dob;

    private Date doj;

    private boolean employeeStatus;

    public Employee(Integer id, String name, Date dob, Date doj, boolean employeeStatus) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.employeeStatus = employeeStatus;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", doj=" + doj +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}
