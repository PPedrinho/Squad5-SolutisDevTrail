package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.ApoliceSeguro;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.ApoliceSeguroRepository;

@Controller
@RequestMapping("/apoliceSeguro")
@RestController
public class ApoliceSeguroController {
    
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @GetMapping
    public ResponseEntity<List<ApoliceSeguro>> buscarTodasApoliceSeguro(){
        try{
            List<ApoliceSeguro> apoliceSeguro = apoliceSeguroRepository.findAll();
        if (apoliceSeguro.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(apoliceSeguro);
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoliceSeguro> buscarApoliceSeguroPorId(@PathVariable Long id){
        try {
            ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(id).get();
            if (apoliceSeguro == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(apoliceSeguro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<ApoliceSeguro> cadastrarApoliceSeguro(@RequestBody ApoliceSeguro apoliceSeguro){
        try {
            apoliceSeguroRepository.save(apoliceSeguro);
            return ResponseEntity.ok(apoliceSeguro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoliceSeguro> atualizarApoliceSeguro(@PathVariable Long id, @RequestBody ApoliceSeguro apoliceSeguro){
        try {
            apoliceSeguroRepository.save(apoliceSeguro);
            return ResponseEntity.ok(apoliceSeguro);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarApoliceSeguro(@PathVariable Long id){
        try {
            apoliceSeguroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
