package com.example.demo.employee.repository;

import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;
import com.example.demo.employee.mapper.EmployeeProjectMapper;
import com.example.demo.employee.dataModel.EmployeeProject;
import com.example.demo.employee.mapper.EmployeeRowMapper;
import com.example.demo.employee.mapper.ProjectRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

    @Autowired
    JdbcTemplate template;

    @Override
    public void createProject(String name, String domain, String account) {
        String sql = "insert into project (projname, domaine, account) values (?, ?, ?)";
        template.update(sql, name, domain, account);
    }

    @Override
    public void allocateProject(Integer employeeId, Integer projectId) {
        String allocateSql = "insert into emp_proj (employee_id, project_id, effective_from, effective_till) values (?, ?, ?, ?)";
        template.update(allocateSql, employeeId, projectId, new Date(System.currentTimeMillis()), null);
    }

    @Override
    public void endOldProjectIfAny(Integer employeeId, Integer projectId) {
        try {
            String sql = "select count(*) from emp_proj where employee_id = ? and effective_till IS NULL";
            int rowCount = template.update(sql, employeeId);
            if (rowCount >0) {
                String updateSql = "update emp_proj set effective_till = (DATE(CURRENT_TIMESTAMP)) where employee_id = ? and project_id = ?";
                template.update(updateSql, employeeId, projectId);
            }
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Allocating for First time");
        }
    }

    @Override
    public Project getProject(Integer projectId) {
        String getProjectSql = "select id, projname, account, domaine from project where id = ?";
        Project project = template.queryForObject(getProjectSql, new ProjectRowMapper(), projectId);
        return project;
    }

    @Override
    public List<Integer> getAssociatedEmployees(Integer projectId) {
        String sql = "select employee_id from emp_proj where project_id = ? and effective_till is null";
        List<Integer> employeeIds = template.queryForList(sql, Integer.class);
        return employeeIds;
    }
}
