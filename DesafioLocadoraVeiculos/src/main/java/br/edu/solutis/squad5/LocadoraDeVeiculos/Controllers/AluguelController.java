package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Aluguel;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.AluguelRepository;
import org.springframework.dao.OptimisticLockingFailureException;

@Controller
@RequestMapping("/alugueis")
@RestController
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @GetMapping
    public ResponseEntity<List<Aluguel>> buscarTodosAlugueis() {
        try {
            List<Aluguel> alugueis = aluguelRepository.findAll();
            if (alugueis.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(alugueis);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscarAluguelPorId(@PathVariable("id") Long id) {
        try {
            Aluguel aluguel = aluguelRepository.findById(id).get();
            if (aluguel == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(aluguel);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Aluguel> criarAluguel(@RequestBody Aluguel aluguel) {
        try {
            aluguelRepository.save(aluguel);
            return ResponseEntity.ok(aluguel);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        try {
            aluguelRepository.save(aluguel);
            return ResponseEntity.ok(aluguel);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable("id") Long id) {
        try {
            aluguelRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}