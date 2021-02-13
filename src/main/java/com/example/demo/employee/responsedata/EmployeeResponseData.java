package com.example.demo.employee.responsedata;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;

import java.util.Date;
import java.util.List;

public class EmployeeResponseData {

    private Employee employee;

    private boolean employeeStatus;

    private Project currentProject;

    private List<Project> previousProjects;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public List<Project> getPreviousProjects() {
        return previousProjects;
    }

    public void setPreviousProjects(List<Project> previousProjects) {
        this.previousProjects = previousProjects;
    }
}
