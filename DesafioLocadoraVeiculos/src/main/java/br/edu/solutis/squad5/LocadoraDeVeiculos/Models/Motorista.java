package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue(value = "M")
public class Motorista extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_cnh", nullable = true, unique = true)
    private String numeroCNH;

    public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH) {
        super(nome, dataNascimento, cpf, sexo);
        this.numeroCNH = numeroCNH;
    }

    public Motorista() {

    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    @Override
    public String toString() {
        return "Motorista [numeroCNH=" + numeroCNH + ", nome=" + getNome() + ", dataNascimento=" + getDataNascimento()
                + ", cpf=" + getCpf() + ", sexo=" + getSexo() + "]";
    }

    public int getId() {
        return id;
    }

    
    //private Aluguel aluguel;

    // public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH, Aluguel aluguel) {
    //     super(nome, dataNascimento, cpf, sexo);
    //     this.numeroCNH = numeroCNH;
    //     this.aluguel = aluguel;
    // }
}
