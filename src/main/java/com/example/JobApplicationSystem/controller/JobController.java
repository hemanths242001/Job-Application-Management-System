package com.example.JobApplicationSystem.controller;

import com.example.JobApplicationSystem.model.Applicant;
import com.example.JobApplicationSystem.model.Job;
import com.example.JobApplicationSystem.service.ApplicantService;
import com.example.JobApplicationSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired private JobService jobService;
    @Autowired private ApplicantService applicantService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        return jobService.updateJob(id, updatedJob);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "Job deleted successfully.";
    }

    @PostMapping("/{jobId}/apply")
    public String apply(@PathVariable Long jobId, @RequestBody Applicant applicant) {
        return applicantService.applyToJob(jobId, applicant);
    }
}