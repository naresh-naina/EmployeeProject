package com.example.demo.employee.repository;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;

import java.util.Date;
import java.util.List;

public interface EmployeeRepo {

    void createEmployee(String name, Date dob);

    void terminateEmployee(Integer employeeId);

    public Employee getEmployee(Integer id);

    public Project getCurrentProjectForEmployee(Integer id);

    public List<Project> getPreviousProjects(Integer id);

}
