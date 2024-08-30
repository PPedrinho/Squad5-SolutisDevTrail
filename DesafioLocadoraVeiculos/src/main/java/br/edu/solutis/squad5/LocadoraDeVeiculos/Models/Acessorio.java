package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import java.util.ArrayList;
import java.util.List;

public class Acessorio {
    private String descricao;
    private List<Carro> carros = new ArrayList<>();

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
