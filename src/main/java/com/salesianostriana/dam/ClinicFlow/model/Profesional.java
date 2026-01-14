package com.salesianostriana.dam.ClinicFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    @OneToMany(fetch = FetchType.LAZY)
    @Builder.Default
    private List<Cita> citas = new ArrayList<>();
}
