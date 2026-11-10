package com.gremio.agenda_web.repository;

import com.gremio.agenda_web.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}