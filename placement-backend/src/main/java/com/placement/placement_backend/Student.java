package com.placement.placement_backend;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String branch;
    private Double cgpa;
    private String skills;
}