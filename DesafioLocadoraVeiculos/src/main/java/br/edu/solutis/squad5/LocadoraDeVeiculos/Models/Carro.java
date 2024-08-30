package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private ModeloCarro modeloCarro;
    private List<Acessorio> acessorios = new ArrayList<>();
    //colocar alugueis

    public Carro(String placa, String chassi, String cor, BigDecimal valorDiaria, ModeloCarro modeloCarro) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.modeloCarro = modeloCarro;
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        acessorios.add(acessorio);
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    // Getters simples
    public String getPlaca() { return placa; }
    public String getChassi() { return chassi; }
    public String getCor() { return cor; }
    public BigDecimal getValorDiaria() { return valorDiaria; }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ModeloCarro getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(ModeloCarro modeloCarro) {
        this.modeloCarro = modeloCarro;
    }
    
}
