package com.salesianostriana.dam.ClinicFlow.service;

import com.salesianostriana.dam.ClinicFlow.dto.CitaDetailDto;
import com.salesianostriana.dam.ClinicFlow.dto.CitaListDto;
import com.salesianostriana.dam.ClinicFlow.dto.CreateCitaRequest;
import com.salesianostriana.dam.ClinicFlow.model.*;
import com.salesianostriana.dam.ClinicFlow.repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.repository.ConsultaRepository;
import com.salesianostriana.dam.ClinicFlow.repository.PacienteRepository;
import com.salesianostriana.dam.ClinicFlow.repository.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;
    private final ProfesionalRepository profesionalRepository;

    public Cita asignarCita (CreateCitaRequest dto) {
        Paciente paciente = pacienteRepository.findById(dto.idPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrada"));
        Profesional profesional = profesionalRepository.findById(dto.idProfesional()).orElseThrow(() -> new RuntimeException("Profesional no encontrado"));
        Cita ultimaCita = citaRepository.findFirstByPacienteOrderByFechaHoraDesc(paciente).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        Cita c;

        if(dto.fechaHora().isBefore(LocalDateTime.now()) || !pacienteRepository.existsCitaOnDay(dto.fechaHora()) || ultimaCita.getFechaHora() != dto.fechaHora()){
             c = Cita.builder()
                    .fechaHora(dto.fechaHora())
                    .estado(Estado.PROGRAMADA)
                    .paciente(paciente)
                    .profesional(profesional)
                    .consulta(null)
                    .build();
             return citaRepository.save(c);
        } else {
            throw new RuntimeException("Hay un problema con la cita de la consulta");
        }
    }

    public Cita cancelarCita (Long idCita){
        Cita cita = citaRepository.findById(idCita).orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if(cita.getEstado()!=Estado.ATENDIDA){
            cita.setEstado(Estado.CANCELADA);
            return citaRepository.save(cita);
        } else{
            throw new RuntimeException("No se puede cancelar una cita que ya ha sido atendida");
        }
    }

    public List<Cita> mostrarCitaPaciente (Long idPaciente) {
        Paciente p = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return citaRepository.findCitaByPaciente(p);
    }


}
