package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Estado;

import java.time.LocalDateTime;

public record CreateCitaRequest(LocalDateTime fechaHora, Long idProfesional, Long idPaciente) {



}
