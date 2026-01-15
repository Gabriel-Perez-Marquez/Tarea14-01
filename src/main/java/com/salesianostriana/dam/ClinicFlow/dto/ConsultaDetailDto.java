package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Consulta;

import java.time.LocalDateTime;

public record ConsultaDetailDto(Long id,
                                String observaciones,
                                String diagnostico,
                                LocalDateTime fecha,
                                Long idCita) {

    public static ConsultaDetailDto of(Consulta c){
        return new ConsultaDetailDto(
                c.getId(),
                c.getObservaciones(),
                c.getDiagnostico(),
                c.getFecha(),
                c.getCita().getId()
        );
    }
}
