package com.mk.springbootapp.model;

public class EmployeeDto {

    private Long id;
    private String name;
    private String job;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
