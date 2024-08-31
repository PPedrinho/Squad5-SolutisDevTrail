package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.ModeloCarro;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.ModeloCarroRepository;

@Controller
@RestController
@RequestMapping("/modelosCarro")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @GetMapping
    public ResponseEntity<List<ModeloCarro>> buscarTodosModelosCarro() {
        try {
            List<ModeloCarro> modelosCarro = modeloCarroRepository.findAll();
            return ResponseEntity.ok(modelosCarro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarro> buscarModeloCarroPorId(@PathVariable int id) {
        try {
            ModeloCarro modelo = modeloCarroRepository.findById(id).get();
            return ResponseEntity.ok(modelo);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<ModeloCarro> criarModeloCarro(@RequestBody ModeloCarro modelo) {
        try {
            modeloCarroRepository.save(modelo);
            return ResponseEntity.ok(modelo);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarModeloCarro(@PathVariable int id) {
        try {
            modeloCarroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
