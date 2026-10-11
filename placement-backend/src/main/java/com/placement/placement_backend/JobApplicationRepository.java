package com.placement.placement_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    boolean existsByJob_IdAndStudent_Id(Long jobId, Long studentId);
    List<JobApplication> findByStudent_Id(Long studentId);
    List<JobApplication> findByJob_Id(Long jobId);
}