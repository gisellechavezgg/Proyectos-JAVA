package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String producto;
    private String modificador; 
    private double subtotal;

    public ItemPedido() {}
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public String getModificador() { return modificador; }
    public void setModificador(String modificador) { this.modificador = modificador; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}