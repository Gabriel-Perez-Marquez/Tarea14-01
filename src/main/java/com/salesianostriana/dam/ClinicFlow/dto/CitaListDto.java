package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Estado;

import java.time.LocalDateTime;
import java.util.List;

public record CitaListDto(Long id,
                          LocalDateTime fechaHora,
                          Estado estado,
                          Long idProfesional,
                          Long idPaciente) {

    public static CitaListDto of(Cita c) {
        return new CitaListDto(
                c.getId(),
                c.getFechaHora(),
                c.getEstado(),
                c.getProfesional().getId(),
                c.getPaciente().getId()
        );
    }
}
