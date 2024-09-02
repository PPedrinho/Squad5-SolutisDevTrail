package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "SEXO")
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao", nullable = false, unique = true)
    private String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    private Sexo(String descricao) {
        this.descricao = descricao;
    }
}
