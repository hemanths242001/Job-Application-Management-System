package com.example.JobApplicationSystem.repository;

import com.example.JobApplicationSystem.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByJobId(Long jobId);
}
