package com.placement.placement_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/get")
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return repo.save(student);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}