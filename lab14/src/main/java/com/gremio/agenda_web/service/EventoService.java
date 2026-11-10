package com.gremio.agenda_web.service;

import com.gremio.agenda_web.model.Evento;
import com.gremio.agenda_web.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {
    private final EventoRepository repo;

    public EventoService(EventoRepository repo) {
        this.repo = repo;
    }

    public List<Evento> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Evento evento) {
        repo.save(evento);
    }

    public Evento buscarPorId(Long id) {
        return repo.findById(id).orElse(new Evento());
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
