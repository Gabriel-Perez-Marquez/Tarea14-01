package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Estado;

import java.time.LocalDateTime;

public record CitaDetailDto(Long id,
                            LocalDateTime fechaHora,
                            Estado estado,
                            String observaciones,
                            String diagnostico,
                            Long idProfesional,
                            String nombreProfesional,
                            Long idPaciente,
                            String nombrePaciente) {

    public static CitaDetailDto of(Cita c) {
        return new CitaDetailDto(
                c.getId(),
                c.getFechaHora(),
                c.getEstado(),
                c.getConsulta() != null ? c.getConsulta().getObservaciones() : "",
                c.getConsulta() != null ? c.getConsulta().getDiagnostico() : "",
                c.getProfesional().getId(),
                c.getProfesional().getNombre(),
                c.getPaciente().getId(),
                c.getPaciente().getNombre()
        );
    }


}
