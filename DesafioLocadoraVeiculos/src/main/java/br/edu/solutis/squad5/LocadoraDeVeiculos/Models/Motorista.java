package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue(value = "M")
public class Motorista extends Pessoa {
    private String numeroCNH;
    private Aluguel aluguel;

    public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH, Aluguel aluguel) {
        super(nome, dataNascimento, cpf, sexo);
        this.numeroCNH = numeroCNH;
        this.aluguel = aluguel;
    }
}
