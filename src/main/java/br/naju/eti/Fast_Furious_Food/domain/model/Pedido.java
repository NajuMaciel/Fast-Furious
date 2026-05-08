/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.domain.model;

import br.naju.eti.Fast_Furious_Food.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sesi3dia
 */
@Entity
public class Pedido {
//todas as informações da classe    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @NotBlank
    @Size (max = 20)
    private String cpf;
    
    @NotBlank
    private String cliente;
    
    @Enumerated(EnumType.STRING) //salva o status como informação "aberto", se quiser em numero usar o "EnumType.ORDINAL"
    private StatusPedido status;
    
    private LocalDateTime dtAberto;
    private LocalDateTime dtFinalizada;
    private LocalDateTime dtCancelada;
    private LocalDateTime dtPronta;
    
    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <ItemPedido> listaItens;

//construtor    
    public Pedido() {
    }

    public Pedido(Long Id, String cpf, String cliente, StatusPedido status, LocalDateTime dtAberto, LocalDateTime dtFinalizada, LocalDateTime dtCancelada, LocalDateTime dtPronta, List<ItemPedido> listaItens) {
        this.Id = Id;
        this.cpf = cpf;
        this.cliente = cliente;
        this.status = status;
        this.dtAberto = dtAberto;
        this.dtFinalizada = dtFinalizada;
        this.dtCancelada = dtCancelada;
        this.dtPronta = dtPronta;
        this.listaItens = listaItens;
    }
    
    
    public List<ItemPedido> getListaItens() {    
        return listaItens;
    }

    //getters & setters
    public void setListaItens(List<ItemPedido> listaItens) {
        this.listaItens = listaItens;
    }

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

    public LocalDateTime getDtFinalizada() {
        return dtFinalizada;
    }

    public void setDtFechado(LocalDateTime dtFinalizada) {
        this.dtFinalizada = dtFinalizada;
    }

    public LocalDateTime getDtCancelada() {
        return dtCancelada;
    }

    public void setDtCancelada(LocalDateTime dtCancelada) {
        this.dtCancelada = dtCancelada;
    }

    public LocalDateTime getDtPronta() {
        return dtPronta;
    }

    public void setDtPronta(LocalDateTime dtPronta) {
        this.dtPronta = dtPronta;
    }
    
    
    
}
