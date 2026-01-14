package com.salesianostriana.dam.ClinicFlow.dto;

import java.time.LocalDateTime;

public record ConsultaDetailDto(Long id,
                                String observaciones,
                                String diagnostico,
                                LocalDateTime fecha,
                                Long idCita) {
}
