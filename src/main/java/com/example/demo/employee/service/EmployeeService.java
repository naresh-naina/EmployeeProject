package com.example.demo.employee.service;

import com.example.demo.employee.dataModel.Project;
import com.example.demo.employee.requestdata.EmployeeRequestData;
import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.repository.EmployeeRepo;
import com.example.demo.employee.responsedata.EmployeeResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public void createEmployee (EmployeeRequestData requestData) {
        employeeRepo.createEmployee(requestData.getName(), requestData.getDob());
    }

    public void terminateEmployee(Integer id) {
        employeeRepo.terminateEmployee(id);
    }

    public EmployeeResponseData getEmployeeDetails(Integer id) {
        EmployeeResponseData employeeResponseData = new EmployeeResponseData();
        Employee employee = employeeRepo.getEmployee(id);
        Project currentProject = employeeRepo.getCurrentProjectForEmployee(id);
        List<Project> previousProjects = employeeRepo.getPreviousProjects(id);
        employeeResponseData.setEmployee(employee);
        employeeResponseData.setCurrentProject(currentProject);
        employeeResponseData.setPreviousProjects(previousProjects);
        return employeeResponseData;
    }
}
