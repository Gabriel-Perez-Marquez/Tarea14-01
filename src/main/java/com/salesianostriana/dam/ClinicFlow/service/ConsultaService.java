package com.salesianostriana.dam.ClinicFlow.service;

import com.salesianostriana.dam.ClinicFlow.dto.CreateConsultaRequest;
import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Consulta;
import com.salesianostriana.dam.ClinicFlow.model.Estado;
import com.salesianostriana.dam.ClinicFlow.repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final CitaRepository citaRepository;
    private final ConsultaRepository consultaRepository;


    public Consulta registrarConsulta (CreateConsultaRequest dto){
        Cita cita = citaRepository.findById(dto.idCita()).orElseThrow(() -> new RuntimeException("Cita mp encontrada"));
        Consulta consulta;

        if(cita.getEstado()== Estado.PROGRAMADA){
            consulta = Consulta.builder()
                    .observaciones(dto.observaciones())
                    .diagnostico(dto.diagnostico())
                    .fecha(dto.fecha())
                    .cita(cita)
                    .build();
            cita.setEstado(Estado.ATENDIDA);
            return consultaRepository.save(consulta);
        } else {
            throw new RuntimeException("No se puede resgitrar de una cita que ya ha sido atendido o cancelada");
        }

    }
}
