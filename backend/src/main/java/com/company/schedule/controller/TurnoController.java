package com.company.schedule.controller;

import com.company.schedule.model.Turno;
import com.company.schedule.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoRepository turnoRepository;

    @GetMapping
    public List<Turno> getTodosLosTurnos() {
        return turnoRepository.findAll();
    }

    @GetMapping("/dia/{dia}")
    public List<Turno> getTurnosPorDia(@PathVariable String dia) {
        LocalDate diaParsed = LocalDate.parse(dia);
        return turnoRepository.findByDia(diaParsed);
    }

    @PostMapping
    public Turno crearTurno(@RequestBody Turno turno) {
        Optional<Turno> turnoExistente = turnoRepository.findByDiaAndHora(turno.getDia(), turno.getHora());
        if (turnoExistente.isPresent()) {
            throw new RuntimeException("Ya existe un turno en ese horario");
        }

        return turnoRepository.save(turno);
    }
}


