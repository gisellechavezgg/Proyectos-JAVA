package com.gremio.agenda_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Danzante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String estado;
    private String agrupacion;
    private String calzado;

    public Danzante() {}

    public Danzante(String nombre, String estado, String agrupacion, String calzado) {
        this.nombre = nombre;
        this.estado = estado;
        this.agrupacion = agrupacion;
        this.calzado = calzado;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }
    public String getAgrupacion() { return agrupacion; }
    public String getCalzado() { return calzado; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setAgrupacion(String agrupacion) { this.agrupacion = agrupacion; }
    public void setCalzado(String calzado) { this.calzado = calzado; }
}