package com.example.demo.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BARISTA")
public class Barista extends Empleado {
    private String especialidad = "Arte Latte";
    
    public Barista() {}
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}