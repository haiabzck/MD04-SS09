package com.example.session09.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id" , nullable = false)
    @JsonBackReference
    private Department department;

    @Column(name = "avatar_url")
    private String avatarUrl;
}
