package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Carro;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.CarroRepository;


@Controller
@RequestMapping("/carros")
@RestController
public class CarroController {
    
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodosCarros() {
        try {
            List<Carro> carros = carroRepository.findAll();
            if (carros.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(carros);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable int id) {
        try {
            Carro carro = carroRepository.findById(id).get();
            if (carro == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(carro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carro) {
        try {
            carroRepository.save(carro);
            return ResponseEntity.ok(carro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable int id, @RequestBody Carro carro) {
        try {
            carroRepository.save(carro);
            return ResponseEntity.ok(carro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable int id) {
        try {
            carroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
