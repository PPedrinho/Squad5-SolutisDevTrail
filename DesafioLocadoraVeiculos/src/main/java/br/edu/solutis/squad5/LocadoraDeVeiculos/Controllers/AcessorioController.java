package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.dao.OptimisticLockingFailureException;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Acessorio;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.AcessorioRepository;

@Controller
@RequestMapping("/acessorios")
@RestController
public class AcessorioController {
    
    @Autowired
    private AcessorioRepository acessorioRepository;

    @GetMapping
    public ResponseEntity<List<Acessorio>> buscarTodosAcessorios() {
        try {
            List<Acessorio> acessorios = acessorioRepository.findAll();
            if (acessorios.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(acessorios);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acessorio> buscarAcessorioPorId(@PathVariable int id) {
        try {
            Acessorio acessorio = acessorioRepository.findById(id).get();
            if (acessorio == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(acessorio);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Acessorio> criarAcessorio(@RequestBody Acessorio acessorio) {
        try {
            acessorioRepository.save(acessorio);
            return ResponseEntity.ok(acessorio);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acessorio> atualizarAcessorio(@PathVariable int id, @RequestBody Acessorio acessorio) {
        try {
            acessorioRepository.save(acessorio);
            return ResponseEntity.ok(acessorio);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAcessorio(@PathVariable("id") int id) {
        try {
            acessorioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}