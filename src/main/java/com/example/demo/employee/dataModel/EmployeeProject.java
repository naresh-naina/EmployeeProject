package com.example.demo.employee.dataModel;

import java.util.Date;

public class EmployeeProject {

    private Integer employeeId;

    private Integer projectId;

    private Date effectiveFrom;

    private Date effectiveTill;

    public EmployeeProject() {

    }

    public EmployeeProject(Integer employeeId, Integer projectId, Date effectiveFrom, Date effectiveTill) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTill = effectiveTill;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveTill() {
        return effectiveTill;
    }

    public void setEffectiveTill(Date effectiveTill) {
        this.effectiveTill = effectiveTill;
    }
}
