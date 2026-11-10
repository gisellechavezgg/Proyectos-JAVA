package com.example.demo.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REPARTIDOR")
public class Repartidor extends Empleado {
    // Implementamos entregas sobre ruedas
    private String tipoTransporte = "Patines de 4 ruedas"; 
    
    public Repartidor() {}
    public String getTipoTransporte() { return tipoTransporte; }
    public void setTipoTransporte(String tipoTransporte) { this.tipoTransporte = tipoTransporte; }
}