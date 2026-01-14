package com.salesianostriana.dam.ClinicFlow.repository;

import com.salesianostriana.dam.ClinicFlow.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    @Query("select (count(p) > 0) from Paciente p inner join p.citas citas where citas.fechaHora = ?1")
    boolean existsCitaOnDay(LocalDateTime fechaHora);
}
