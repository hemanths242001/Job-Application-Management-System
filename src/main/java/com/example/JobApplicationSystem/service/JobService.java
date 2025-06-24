package com.example.JobApplicationSystem.service;

import com.example.JobApplicationSystem.model.Job;
import com.example.JobApplicationSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public Job updateJob(Long id, Job updatedJob) {
        Optional<Job> existingJob = jobRepository.findById(id);
        if (existingJob.isPresent()) {
            Job job = existingJob.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setCompany(updatedJob.getCompany());
            job.setLocation(updatedJob.getLocation());
            return jobRepository.save(job);
        } else {
            throw new RuntimeException("Job not found");
        }
    }
}
