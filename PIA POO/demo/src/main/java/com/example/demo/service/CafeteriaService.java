package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CafeteriaService {
    private final ProductoRepository repositorio;

    public CafeteriaService(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Producto> obtenerMenu() {
        return repositorio.findAll();
    }

    public Producto agregarProducto(Producto nuevoProducto) {
        return repositorio.save(nuevoProducto);
    }
}
