package com.example.demo.employee.dataModel;


public class Project {

    private Integer id;

    private String projName;

    private String account;

    private String domaine;

    public Project(){

    }

    public Project(Integer id, String projName, String account, String domaine) {
        this.id = id;
        this.projName = projName;
        this.account = account;
        this.domaine = domaine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}
