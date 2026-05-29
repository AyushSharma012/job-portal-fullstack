package com.jobportal.job_portal_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.job_portal_backend.entity.Job;
import com.jobportal.job_portal_backend.service.GreetingService;
import com.jobportal.job_portal_backend.service.JobService;

@RestController // defines that the created class is used for REST API implementation, this is also managed by IOC container
@RequestMapping("/jobs") // connects requests to controller methods
public class JobController {

    @Autowired // used for DI, takes the bean from IOC container and injects it in the required class
    private JobService jobService;

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String greet(){
        return greetingService.greet();
    }

    @PostMapping
    public String addJob(@RequestBody Job job){
        
        jobService.addJob(job);
        
        return "Job added successfully";
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable int id){
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable int id){
        
        boolean isDeleted = jobService.deleteJob(id);
        
        if(isDeleted){
            return "Job deleted successfully";
        }

        return "Job not deleted";
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable int id, @RequestBody Job updatedJob){
        
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        
        if(isUpdated){
            return "Job updated successfully";
        }

        return "Job not found";
    }

}
