package com.salesianostriana.dam.ClinicFlow.controller;


import com.salesianostriana.dam.ClinicFlow.dto.CitaDetailDto;
import com.salesianostriana.dam.ClinicFlow.dto.CitaListDto;
import com.salesianostriana.dam.ClinicFlow.dto.CreateCitaRequest;
import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;
    private final CitaRepository citaRepository;

    @PostMapping("")
    public CitaDetailDto crearCita(@RequestBody CreateCitaRequest dto){
        return CitaDetailDto.of(citaService.asignarCita(dto);
    }

    @GetMapping("")
    public Page<CitaListDto> mostrarCitasPaginadas(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return citaRepository.findAll(pageable).map(CitaListDto::of);
    }

    @PutMapping("/{id}/cancelar")
    public CitaDetailDto cancelarCita(@PathVariable(name = "id") Long idCita){
        return citaService.cancelarCita(idCita);
    }

    @PostMapping("/{id}/consulta")
    public




}
