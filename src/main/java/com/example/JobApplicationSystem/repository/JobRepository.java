package com.example.JobApplicationSystem.repository;

import com.example.JobApplicationSystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

