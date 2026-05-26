package com.jobportal.job_portal_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.job_portal_backend.entity.Job;

@Service
public class JobService {

    private final List<Job> jobs = new ArrayList<>();

    // add job (post)
    public void addJob(Job job){
        if(job == null){
            throw new RuntimeException("Job cannot be null");
        }
        jobs.add(job);
        System.out.println("Job added successfully");
    }

    // update the details of job (put)
    public boolean updateJob(int id, Job updatedJob){
        for (Job job : jobs) {
            if(job.getId() == id){

                // IDs should not be updated, as it must be immutable
                // job.setId(updatedJob.getId());

                job.setCompanyName(updatedJob.getCompanyName());
                job.setSalary(updatedJob.getSalary());
                job.setLocation(updatedJob.getLocation());
                job.setName(updatedJob.getName());

                return true;
            }
        }

        return false;
    }

    // fetch job (get)
    public Job getJobById(int id){
        for (Job job : jobs) {
            if(job.getId() == id){
                return job;
            }
        }

        return null;
    }

    // detele job
    public boolean deleteJob(int id){
        Job job = getJobById(id);

        if(job == null){
            System.out.println("Job not found");
            return false;
        }

        jobs.remove(job);

        System.out.println("Job removed successfully");

        return true;
    }

    // fetch all jobs (get)
    public List<Job> getAllJobs(){

        // this (below) should not be done, as it allows external code to update the list
        // return jobs;

        return new ArrayList<>(jobs);
    }
}
