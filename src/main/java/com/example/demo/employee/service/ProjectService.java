package com.example.demo.employee.service;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;
import com.example.demo.employee.repository.EmployeeRepo;
import com.example.demo.employee.requestdata.GetProjectRequestData;
import com.example.demo.employee.requestdata.ProjectRequestData;
import com.example.demo.employee.repository.ProjectRepository;
import com.example.demo.employee.responsedata.ProjectResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepo employeeRepo;

    public void createProjects(ProjectRequestData projectRequestData) {
        projectRepository.createProject(projectRequestData.getProjName(),
                projectRequestData.getAccount(), projectRequestData.getDomaine());
    }

    public void allocateProject(GetProjectRequestData requestData) {
        projectRepository.endOldProjectIfAny(requestData.getEmployeeId(), requestData.getProjectId());
        projectRepository.allocateProject(requestData.getEmployeeId(), requestData.getProjectId());
    }

    public ProjectResponseData getProjectDetails(Integer id) {
        ProjectResponseData responseData = new ProjectResponseData();
        Project project = projectRepository.getProject(id);
        List<Integer> employeeIds = projectRepository.getAssociatedEmployees(id);
        List<Employee> employees = new ArrayList<>();
        for (Integer empId: employeeIds) {
            employees.add(employeeRepo.getEmployee(empId));
        }
        responseData.setProject(project);
        responseData.setEmployees(employees);
        return responseData;
    }
}
