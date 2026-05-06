/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author sesi3dia
 */
@Entity
public class ItemPedido {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private double qtd;
    private double vUnit;
    private String obs;
    
    @ManyToOne
    @JoinColumn(name="pedido_id")
    @JsonIgnore
    private Pedido pedido;

    

    public ItemPedido() {
    }

    public ItemPedido(Long Id, double qtd, double vUnit, String obs, Pedido pedido) {
        this.Id = Id;
        this.qtd = qtd;
        this.vUnit = vUnit;
        this.obs = obs;
        this.pedido = pedido;
    }
    
   
    public ItemPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getvUnit() {
        return vUnit;
    }

    public void setvUnit(double vUnit) {
        this.vUnit = vUnit;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
    

