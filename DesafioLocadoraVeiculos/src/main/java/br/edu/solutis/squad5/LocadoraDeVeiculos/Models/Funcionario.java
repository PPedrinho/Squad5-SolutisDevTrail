package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue(value = "M")
public class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, Date dataNascimento, String cpf, Sexo sexo, String matricula) {
        super(nome, dataNascimento, cpf, sexo);
        this.matricula = matricula;
    }
}
