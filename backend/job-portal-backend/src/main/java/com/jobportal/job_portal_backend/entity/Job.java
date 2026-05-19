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

    public Job() {
    }

    public Job(Long id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}