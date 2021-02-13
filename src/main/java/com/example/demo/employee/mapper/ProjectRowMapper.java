package com.example.demo.employee.mapper;

import com.example.demo.employee.dataModel.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setProjName(resultSet.getString("projname"));
        project.setAccount(resultSet.getString("account"));
        project.setDomaine(resultSet.getString("domaine"));
        return project;
    }
}
