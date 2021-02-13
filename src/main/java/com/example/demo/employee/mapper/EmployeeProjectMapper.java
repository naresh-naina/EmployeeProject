package com.example.demo.employee.mapper;

import com.example.demo.employee.dataModel.EmployeeProject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeProjectMapper implements RowMapper<EmployeeProject> {
    @Override
    public EmployeeProject mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployeeId(resultSet.getInt("employee_id"));
        employeeProject.setProjectId(resultSet.getInt("project_id"));
        employeeProject.setEffectiveFrom(resultSet.getDate("effective_from"));
        employeeProject.setEffectiveTill(resultSet.getDate("effective_to"));
        return employeeProject;
    }
}
