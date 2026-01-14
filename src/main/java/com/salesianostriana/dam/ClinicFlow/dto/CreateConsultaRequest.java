package com.salesianostriana.dam.ClinicFlow.dto;

import java.time.LocalDateTime;

public record CreateConsultaRequest(String observaciones, String diagnostico, LocalDateTime fecha, Long idCita) {
}
