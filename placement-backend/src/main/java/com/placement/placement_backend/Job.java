package com.placement.placement_backend;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;
    private String requiredSkills;
    private String salary;
}