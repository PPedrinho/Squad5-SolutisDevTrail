package br.edu.solutis.squad5.LocadoraDeVeiculos;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Repository.RepositorioLocutora;

public class Main  {
    private RepositorioLocutora repo = new RepositorioLocutora();

    public static void main(String[] args) {
        Main main = new Main();
        main.repo.fecharConexao();
    }
}
