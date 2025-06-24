package com.example.JobApplicationSystem.service;


import com.example.JobApplicationSystem.model.Applicant;
import com.example.JobApplicationSystem.model.Job;
import com.example.JobApplicationSystem.repository.ApplicantRepository;
import com.example.JobApplicationSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired private ApplicantRepository applicantRepository;
    @Autowired private JobRepository jobRepository;

    public String applyToJob(Long jobId, Applicant applicant) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            applicant.setJob(job.get());
            applicantRepository.save(applicant);
            return "Application submitted successfully!";
        } else {
            return "Job not found.";
        }
    }
}
