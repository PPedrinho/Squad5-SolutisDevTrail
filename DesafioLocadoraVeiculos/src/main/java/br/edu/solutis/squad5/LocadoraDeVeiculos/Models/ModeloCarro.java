package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODELOS_CARROS")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "descricao", nullable = false, unique = false)
    private String descricao;

    @JoinColumn(name = "fabricante_id")

    @Column(name = "categoria", nullable = false, unique = false)
    private Categoria categoria;

    @JoinColumn(name = "fabricante_id")
    @ManyToOne
    private Fabricante fabricante;

    public ModeloCarro() {}

    public ModeloCarro(String descricao, Fabricante fabricante, Categoria categoria) {
        this.descricao = descricao;
        //this.fabricante = fabricante;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // public Fabricante getFabricante() {
    //     return fabricante;
    // }

    // public void setFabricante(Fabricante fabricante) {
    //     this.fabricante = fabricante;
    // }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}

