package com.salesianostriana.dam.ClinicFlow.controller;


import com.salesianostriana.dam.ClinicFlow.dto.*;
import com.salesianostriana.dam.ClinicFlow.repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.service.CitaService;
import com.salesianostriana.dam.ClinicFlow.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;
    private final CitaRepository citaRepository;
    private final ConsultaService consultaService;

    @PostMapping("/citas")
    public CitaDetailDto crearCita(@RequestBody CreateCitaRequest dto){
        return CitaDetailDto.of(citaService.asignarCita(dto));
    }

    @GetMapping("/citas")
    public Page<CitaListDto> mostrarCitasPaginadas(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return citaRepository.findAll(pageable).map(CitaListDto::of);
    }

    @PutMapping("/citas/{id}/cancelar")
    public CitaDetailDto cancelarCita(@PathVariable(name = "id") Long idCita){
        return CitaDetailDto.of(citaService.cancelarCita(idCita));
    }

    @PostMapping("/citas/{id}/consulta")
    public ConsultaDetailDto registrarConsulta (@RequestBody CreateConsultaRequest dto) {
        return ConsultaDetailDto.of(consultaService.registrarConsulta(dto));
    }

    @GetMapping("/pacientes/{id}/citas")
    public List<CitaListDto> mostrarConsultasPaciente (@PathVariable(name = "id") Long idPaciente ) {
        return citaService.mostrarCitaPaciente(idPaciente).stream().map(CitaListDto::of).toList();
    }

}
