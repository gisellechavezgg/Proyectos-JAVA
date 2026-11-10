package com.gremio.agenda_web.repository;

import com.gremio.agenda_web.model.Danzante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanzanteRepository extends JpaRepository<Danzante, Long> {
}