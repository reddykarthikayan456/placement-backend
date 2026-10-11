package com.placement.placement_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobRepository repo;

    @GetMapping("/get")
    public List<Job> getAll(@RequestParam(required = false) String keyword) {
        if (keyword == null) {
            return repo.findAll();
        }
        return repo.findByTitleContainingIgnoreCase(keyword);
    }

    @PostMapping("/add")
    public Job add(@RequestBody Job job) {
        return repo.save(job);
    }

    @PutMapping("/update/{id}")
    public Job update(@PathVariable Long id, @RequestBody Job job) {
        job.setId(id);
        return repo.save(job);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}