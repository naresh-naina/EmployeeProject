package com.example.demo.employee.responsedata;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;

import java.util.List;

public class ProjectResponseData {

    private Project project;

    private List<Employee> employees;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
