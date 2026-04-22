/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public ItemPedido() {
    }
    
    public ItemPedido (Long Id, double qtd, double vUnit, String obs) {
        this.Id = Id;
        this.qtd = qtd;
        this.vUnit = vUnit;
        this.obs = obs;
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
    

