package com.example.ems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(name = "first_name", nullable = false) private String firstName;

    @Column(name = "last_name", nullable = false) private String lastName;

    @Column(name = "email", nullable = false) private String email;

    public Employee(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
