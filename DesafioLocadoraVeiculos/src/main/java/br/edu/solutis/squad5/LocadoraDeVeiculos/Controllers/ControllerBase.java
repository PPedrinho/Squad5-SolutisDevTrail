package br.edu.solutis.squad5.LocadoraDeVeiculos.Controllers;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;

public abstract class ControllerBase {
    private RepositorioLocutora repo;

    public ControllerBase (RepositorioLocutora repo) {
        this.repo = repo;
    }

    public RepositorioLocutora getRepo() {
        return repo;
    }

    public void setRepo(RepositorioLocutora repo) {
        this.repo = repo;
    }

    
}
