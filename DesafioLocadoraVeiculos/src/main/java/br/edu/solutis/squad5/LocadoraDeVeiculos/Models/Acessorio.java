package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACESSORIOS")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao", nullable = false, unique = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "CARROS_ACESSORIOS")
    private List<Carro> carros = new ArrayList<>();

    
    
    public Acessorio() {
    }

    public Acessorio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void addCarro(Carro carro) {
        carros.add(carro);
    }
}
