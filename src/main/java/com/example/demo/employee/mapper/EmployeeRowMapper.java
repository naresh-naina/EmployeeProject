package com.example.demo.employee.mapper;

import com.example.demo.employee.dataModel.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setDob(resultSet.getDate("dob"));
        employee.setDoj(resultSet.getDate("doj"));
        employee.setEmployeeStatus(resultSet.getBoolean("status"));
        return employee;
    }
}
