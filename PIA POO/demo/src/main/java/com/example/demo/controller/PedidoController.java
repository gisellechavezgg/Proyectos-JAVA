package com.example.demo.controller;
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoRepository repo;

    public PedidoController(PedidoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Pedido> verPedidos() { return repo.findAll(); }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido nuevo) { return repo.save(nuevo); }

    @PutMapping("/{id}/estado")
    public Pedido avanzarEstado(@PathVariable int id) {
        Pedido p = repo.findById(id).orElseThrow();
        if (p.getEstado().equals("Recibido")) p.setEstado("Preparando");
        else if (p.getEstado().equals("Preparando")) p.setEstado("Listo");
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id) {
        repo.deleteById(id);
    }
}