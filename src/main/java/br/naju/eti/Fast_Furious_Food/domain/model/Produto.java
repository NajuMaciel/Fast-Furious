
package br.naju.eti.Fast_Furious_Food.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {
//adiciona as informações, tudo que vai conter nessa classe, nomeando em string para informações, e double para numeros
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Size (max = 60)
        private String nome;
        private double valor;
        private double qtd;
        private String categoria;
        private String descricao;
        private String img;

//construtores
    public Produto() {
    }

    public Produto(Long Id, String nome, double valor, double qtd, String categoria, String descricao) {
        this.Id = Id;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
        this.categoria = categoria;
        this.descricao = descricao;
        this.img = img;
    }
//getters & setters
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
             
}
