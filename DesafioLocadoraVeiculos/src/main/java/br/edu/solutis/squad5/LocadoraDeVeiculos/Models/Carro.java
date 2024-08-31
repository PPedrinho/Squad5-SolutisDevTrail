package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARROS")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "chassi", nullable = false, unique = true)
    private String chassi;

    @Column(name = "cor", nullable = false, unique = false)
    private String cor;

    @Column(name = "valor_diaria", nullable = false, unique = false)
    private BigDecimal valorDiaria;

    @JoinColumn(name = "MODELO_CARRO_ID")
    @ManyToOne
    private ModeloCarro modeloCarro;

    @ManyToMany
    @JoinTable(name = "CARROS_ACESSORIOS")
    private List<Acessorio> acessorios = new ArrayList<>();

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    
}
