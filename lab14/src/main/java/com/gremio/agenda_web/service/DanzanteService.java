package com.gremio.agenda_web.service;

import com.gremio.agenda_web.model.Danzante;
import com.gremio.agenda_web.repository.DanzanteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DanzanteService {

    private final DanzanteRepository repo;

    public DanzanteService(DanzanteRepository repo) {
        this.repo = repo;
    }

    public List<Danzante> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Danzante danzante) {
        repo.save(danzante);
    }

    public Danzante buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Danzante no encontrado: " + id));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}