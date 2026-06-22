package com.example.clubapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name="middle_name", length = 100)
    private String middleName;
}