package br.edu.solutis.squad5.LocadoraDeVeiculos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public enum Categoria {
    HATCH_COMPACTO,
    HATCH_MEDIO,
    SEDAN_COMPACTO,
    SEDAN_MEDIO,
    SEDAN_GRANDE,
    MINIVAN,
    ESPORTIVO,
    UTILITARIO_COMERCIAL;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }
}
