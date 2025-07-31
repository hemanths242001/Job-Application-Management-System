package com.example.JobApplicationSystem.repository;

import com.example.JobApplicationSystem.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByJobId(Long jobId);
}
