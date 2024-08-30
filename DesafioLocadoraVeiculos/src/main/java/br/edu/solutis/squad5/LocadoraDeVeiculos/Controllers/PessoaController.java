package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Pessoa;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;

@RestController
public class PessoaController extends ControllerBase {
    
    public PessoaController(RepositorioLocutora repo) {
        super(repo);
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable int id) {
        Pessoa pessoa = getRepo().findPessoa(id);
        if (pessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/pessoas")
    public ResponseEntity<Iterable<Pessoa>> findAll() {
        Iterable<Pessoa> pessoas = getRepo().findAllPessoas();
        if (pessoas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoas);
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!(getRepo().excluir(getRepo().findPessoa(id))))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/pessoas")
    public ResponseEntity<Pessoa> save(Pessoa pessoa) {
        if (!getRepo().cadastrar(pessoa))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable int id, Pessoa pessoa) {
        pessoa.setId(id);
        if (!getRepo().atualizar(pessoa))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(pessoa);
    }
}
