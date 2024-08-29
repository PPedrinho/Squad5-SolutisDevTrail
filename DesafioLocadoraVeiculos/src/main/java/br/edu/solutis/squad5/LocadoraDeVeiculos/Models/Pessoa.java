package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private Sexo sexo;

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
    
    
} 
