package com.salesianostriana.dam.ClinicFlow.repository;

import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Estado;
import com.salesianostriana.dam.ClinicFlow.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {


    Optional<Cita> findFirstByPacienteOrderByFechaHoraDesc(Paciente paciente);

    @Query("select c from Cita c where c.paciente = ?1")
    List<Cita> findCitaByPaciente(Paciente paciente);

    @Query("select c from Cita c where c.estado = ?1")
    List<Cita> findCitaByEstado(Estado estado);

    @Query("select c from Cita c where c.fechaHora between ?1 and ?2")
    List<Cita> findCitaBetweenDates(LocalDateTime fechaHoraStart, LocalDateTime fechaHoraEnd);


}
