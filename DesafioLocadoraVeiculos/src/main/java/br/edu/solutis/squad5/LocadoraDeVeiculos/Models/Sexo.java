package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEXO")
public enum Sexo {
    MASCULINO,
    FEMININO;
}
