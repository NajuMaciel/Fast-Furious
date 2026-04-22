/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.domain.model;

import br.naju.eti.Fast_Furious_Food.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 *
 * @author sesi3dia
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @NotBlank
    @Size (max = 20)
    private String cpf;
    
    @NotBlank
    private String cliente;
    
    @Enumerated(EnumType.STRING) //salva o status como numero
    private StatusPedido status;
    
    private LocalDateTime dtAberto;
    private LocalDateTime dtFechado;
    private LocalDateTime dtEntregue;

    
    //getters & setters
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDtAberto() {
        return dtAberto;
    }

    public void setDtAberto(LocalDateTime dtAberto) {
        this.dtAberto = dtAberto;
    }

    public LocalDateTime getDtFechado() {
        return dtFechado;
    }

    public void setDtFechado(LocalDateTime dtFechado) {
        this.dtFechado = dtFechado;
    }

    public LocalDateTime getDtEntregue() {
        return dtEntregue;
    }

    public void setDtEntregue(LocalDateTime dtEntregue) {
        this.dtEntregue = dtEntregue;
    }
    
    
    
}
