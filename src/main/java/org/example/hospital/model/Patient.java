package org.example.hospital.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String diagnosis;
    private String allergies;
    private String doctor;


    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;
}