package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Motorista;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.MotoristaRepository;

@Controller
@RequestMapping("/motoristas")
@RestController
public class MotoristaController {
    
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping
    public ResponseEntity<List<Motorista>> buscarTodosMotoristas() {
        try {
            List<Motorista> motoristas = motoristaRepository.findAll();
            if (motoristas.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(motoristas);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarMotoristaPorId(@PathVariable("id") int id) {
        try {
            Motorista motorista = motoristaRepository.findById(id).get();
            if (motorista == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(motorista);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Motorista> criarMotorista(@RequestBody Motorista motorista) {
        try {
            System.out.println(motorista);
            motoristaRepository.save(motorista);
            return ResponseEntity.ok(motorista);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorista> atualizarMotorista(@PathVariable("id") int id, @RequestBody Motorista motorista) {
        try {
            motoristaRepository.save(motorista);
            return ResponseEntity.ok(motorista);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Motorista> deletarMotorista(@PathVariable("id") int id) {
        try {
            motoristaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
