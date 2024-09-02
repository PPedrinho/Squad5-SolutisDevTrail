package br.edu.solutis.squad5.LocadoraDeVeiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    
}
