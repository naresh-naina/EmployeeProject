package com.example.demo.employee.repository;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectRepository {

    void createProject(String name, String Domain, String account);

    void allocateProject(Integer employeeId, Integer projectId);

    Project getProject(Integer projectId);

    List<Integer> getAssociatedEmployees(Integer projectId);

    void endOldProjectIfAny(Integer employeeId, Integer projectId);
}
