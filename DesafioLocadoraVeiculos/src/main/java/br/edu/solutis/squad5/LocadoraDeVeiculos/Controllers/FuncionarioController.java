package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Funcionario;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.FuncionarioRepository;

@Controller
@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            if (funcionarios.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(funcionarios);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable int id) {
        try {
            Funcionario funcionario = funcionarioRepository.findById(id).get();
            if (funcionario == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(funcionario);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionario);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionario);
        } catch (OptimisticLockingFailureException olfe) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletarFuncionario(@PathVariable int id) {
        try {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
