package com.example.demo.employee.repository;

import com.example.demo.employee.mapper.EmployeeRowMapper;
import com.example.demo.employee.mapper.ProjectRowMapper;
import com.example.demo.employee.dataModel.Employee;
import com.example.demo.employee.dataModel.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EmployeeRepoImpl implements EmployeeRepo{

    @Autowired
    private JdbcTemplate template;

    @Override
    public void createEmployee(String name, Date dob) {
        String sql = "insert into employee (name, dob, doj, status) values (?, ?, ?, ?)";
        template.update(sql,name, dob, new Date(System.currentTimeMillis()), true);
    }

    @Override
    public void terminateEmployee(Integer employeeId) {
        String sql = "update employee set status = false where id = ?";
        template.update(sql, employeeId);
    }

    @Override
    public Employee getEmployee(Integer id) {
        String getEmployeeSql = "select * from employee where id = ?";
        Employee employee = template.queryForObject(getEmployeeSql, new EmployeeRowMapper(), id);
        return employee;
    }

    @Override
    public Project getCurrentProjectForEmployee(Integer id) {
        try {
            String currentProjectSql = "select id, projname, account, domaine from project where id = (select project_id from emp_proj where employee_id = ? and effective_till IS NULL)";
            Project currentProject = template.queryForObject(currentProjectSql, new ProjectRowMapper(), id);
            return currentProject;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Project> getPreviousProjects(Integer id) {
        try {
            String previousProjectSql = "select * from project where id IN (select  project_id from emp_proj where employee_id = ? and effective_till IS NOT NULL)";
            List<Project> previousProjects = template.query(previousProjectSql, new ProjectRowMapper(), id);
            return previousProjects;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
}
