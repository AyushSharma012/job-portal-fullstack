package com.jobportal.job_portal_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // this treats the class as a table
public class Job {
    
    @Id // defines primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generated the id value + auto increments the value
    private long id;

    private String name;

    private String companyName;

    private String salary;

    private String location;

    public Job() {}

    public Job(Long id, String name, String companyName, String salary, String location) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.salary = salary;
        this.location = location;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}