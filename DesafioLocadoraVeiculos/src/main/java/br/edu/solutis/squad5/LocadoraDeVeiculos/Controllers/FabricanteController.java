package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.FabricanteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Fabricante;


@Controller
@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

   @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscarFabricantePorId(@PathVariable int id) {
        try {
           Fabricante fabricante = fabricanteRepository.findById(id).get();
           if (fabricante == null)
               return ResponseEntity.notFound().build();
           return ResponseEntity.ok(fabricante);
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> buscarTodosFabricantes() {
        try {
           List<Fabricante> fabricantes = fabricanteRepository.findAll();
           if (fabricantes.isEmpty())
               return ResponseEntity.noContent().build();
           return ResponseEntity.ok(fabricantes);
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Fabricante> criarFabricante(@RequestBody Fabricante fabricante) {
        try {
           fabricanteRepository.save(fabricante);
           return ResponseEntity.ok(fabricante);
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> atualizarFabricante(@RequestBody Fabricante fabricante) {
        try {
           fabricanteRepository.save(fabricante);
           return ResponseEntity.ok(fabricante);
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fabricante> deletarFabricante(@PathVariable int id) {
        try {
           fabricanteRepository.deleteById(id);
           return ResponseEntity.ok().build();
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }
}
