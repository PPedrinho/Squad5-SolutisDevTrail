package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, unique = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false, unique = false)
    private Date dataNascimento;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "sexo", nullable = false, unique = false)
    private Sexo sexo;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, Date dataNascimento, String cpf, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Pessoa(String nome, Date dataNascimento, String cpf, Sexo sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", id=" + id + ", nome=" + nome
                + ", sexo=" + sexo + "]";
    }
} 
