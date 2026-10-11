package com.placement.placement_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "*")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository repo;

    @GetMapping("/get")
    public List<JobApplication> getAll() {
        return repo.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<JobApplication> byStudent(@PathVariable Long studentId) {
        return repo.findByStudent_Id(studentId);
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplication> byJob(@PathVariable Long jobId) {
        return repo.findByJob_Id(jobId);
    }

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody JobApplication app) {
        Long jobId = app.getJob().getId();
        Long studentId = app.getStudent().getId();

        if (repo.existsByJob_IdAndStudent_Id(jobId, studentId)) {
            return ResponseEntity.badRequest().body("Already applied for this job");
        }
        app.setStatus("APPLIED");
        app.setAppliedOn(LocalDate.now());
        return ResponseEntity.ok(repo.save(app));
    }

    @PutMapping("/status/{id}")
    public JobApplication updateStatus(@PathVariable Long id, @RequestParam String status) {
        JobApplication app = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status);
        return repo.save(app);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}