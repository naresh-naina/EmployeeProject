package com.example.demo.employee.controller;

import com.example.demo.employee.dataModel.Project;
import com.example.demo.employee.requestdata.EmployeeRequestData;
import com.example.demo.employee.requestdata.GetProjectRequestData;
import com.example.demo.employee.requestdata.ProjectRequestData;
import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.responsedata.EmployeeResponseData;
import com.example.demo.employee.responsedata.ProjectResponseData;
import com.example.demo.employee.service.EmployeeService;
import com.example.demo.employee.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class EmployeeProjectController {

    private static final Logger logger  = LogManager.getLogger(EmployeeProjectController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeRequestData employeeRequestData) {
         employeeService.createEmployee(employeeRequestData);
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseData getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeDetails(id);
    }

    @PutMapping("/employees/terminate")
    public void terminateEmployee(@RequestBody Integer employeeId) {
        employeeService.terminateEmployee(employeeId);
    }

    @PostMapping("/projects")
    public void createProject(@RequestBody ProjectRequestData projectRequestData) {
        projectService.createProjects(projectRequestData);
    }

   @PutMapping("/employees/projects")
    public void allocateProject(@RequestBody GetProjectRequestData requestData) {
        projectService.allocateProject(requestData);
    }

    @GetMapping("/projects/{id}")
    public ProjectResponseData getProject(@PathVariable Integer id) {
        return projectService.getProjectDetails(id);
    }

}
