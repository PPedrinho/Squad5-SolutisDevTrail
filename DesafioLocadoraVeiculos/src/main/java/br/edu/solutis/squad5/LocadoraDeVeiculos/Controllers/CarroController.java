package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Carro;

@RestController
public class CarroController extends ControllerBase {
    
    public CarroController(RepositorioLocutora repo) {
        super(repo);
    }

    @GetMapping("/carros/{id}")
    public ResponseEntity<Carro> findById(@PathVariable int id) {
        Carro carro = getRepo().findCarro(id);
        if (carro == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/carros")
    public ResponseEntity<Iterable<Carro>> findAll() {
        Iterable<Carro> carros = getRepo().findAllCarros();
        if (carros == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carros);
    }

    @DeleteMapping("/carros/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!(getRepo().excluir(getRepo().findCarro(id))))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/carros")
    public ResponseEntity<Carro> save(Carro carro) {
        if (!getRepo().cadastrar(carro))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(carro);
    }

    @PostMapping("/carros/{id}")
    public ResponseEntity<Carro> update(@PathVariable int id, Carro carro) {
        carro.setId(id);
        if (!getRepo().atualizar(carro))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(carro);
    }


}
