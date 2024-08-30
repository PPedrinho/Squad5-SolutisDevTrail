package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Fabricante;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;

public class FabricanteController extends ControllerBase {
    public FabricanteController(RepositorioLocutora repositorio) {
        super(repositorio);
    }

    @GetMapping("/fabricantes")
    public ResponseEntity<Iterable<Fabricante>> findAll() {
        Iterable<Fabricante> fabricantes = getRepo().findAllFabricantes();
        if (fabricantes == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(fabricantes);
    }
}
