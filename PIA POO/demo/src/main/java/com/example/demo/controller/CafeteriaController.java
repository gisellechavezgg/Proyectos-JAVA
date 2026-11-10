package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.CafeteriaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cafeteria")
public class CafeteriaController {
   private final CafeteriaService servicio;

    public CafeteriaController(CafeteriaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/menu")
    public List<Producto> verMenu() {
        return servicio.obtenerMenu();
    }

    @PostMapping("/nuevo")
    public Producto registrarProducto(@RequestBody Producto producto) {
        return servicio.agregarProducto(producto);
    }
}
