package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.Pessoa;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.PessoaRepository;
import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;

@RestController
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaRepository pessoaRepo;

    @GetMapping("/pessoas")
    public List<Pessoa> buscarPessoas(){
        return pessoaRepo.findAll();
    } 
}
