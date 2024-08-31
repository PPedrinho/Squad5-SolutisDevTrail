package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Pessoa;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.PessoaRepository;

import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping()
    private ResponseEntity<List<Pessoa>> buscarTodasPessoas() {
        try {
            List<Pessoa> pessoas = pessoaRepo.findAll();
            if (pessoas.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(pessoas);    
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable("id") int id) {
        try {
            Pessoa pessoa = pessoaRepo.findById(id).get();
            if (pessoa == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(pessoa);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    private ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        try {
            //System.out.println(pessoa);
            pessoaRepo.save(pessoa);
            return ResponseEntity.ok(pessoa);
        } catch (OptimisticLockingFailureException olfe){
            return ResponseEntity.status(409).build();
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) {
        try {
            pessoaRepo.save(pessoa);
            return ResponseEntity.ok(pessoa);
        } catch (OptimisticLockingFailureException olfe){
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletarPessoa(@PathVariable("id") int id) {
        try {
            pessoaRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
