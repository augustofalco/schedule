package com.company.schedule.repository;

import com.company.schedule.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByDia(LocalDate dia);
    Optional<Turno> findByDiaAndHora(LocalDate dia, LocalTime hora);
}



