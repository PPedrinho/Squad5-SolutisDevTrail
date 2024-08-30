package br.edu.solutis.squad5.LocadoraDeVeiculos.Repository;

import java.util.List;

import br.edu.solutis.squad5.LocadoraDeVeiculos.Models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RepositorioLocutora {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrariavirtualsquad5");
    EntityManager em = emf.createEntityManager();

    public void fecharConexao(){
        em.close();
        emf.close();
    }

    public boolean cadastrar(Object objeto) {
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    //metodos de busca unitária
    public Pessoa findPessoa(int id) {
        return em.find(Pessoa.class, id);
    }

    public Sexo findSexo(int id) {
        return em.find(Sexo.class, id);
    }

    public ModeloCarro findModeloCarro(int id) {
        return em.find(ModeloCarro.class, id);
    }

    public Fabricante findFabricante(int id) {
        return em.find(Fabricante.class, id);
    }

    public Categoria findCategoria(int id) {
        return em.find(Categoria.class, id);
    }

    public Carro findCarro(int id) {
        return em.find(Carro.class, id);
    }

    public Acessorio findAcessorio(int id) {
        return em.find(Acessorio.class, id);
    }

    //metodos de busca geral
    public List<Pessoa> findAllPessoas() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public List<Sexo> findAllSexos() {
        return em.createQuery("SELECT s FROM Sexo s", Sexo.class).getResultList();
    }

    public List<ModeloCarro> findAllModelosCarro() {
        return em.createQuery("SELECT m FROM ModeloCarro m", ModeloCarro.class).getResultList();
    }

    public List<Fabricante> findAllFabricantes() {
        return em.createQuery("SELECT f FROM Fabricante f", Fabricante.class).getResultList();
    }

    public List<Categoria> findAllCategorias() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public List<Carro> findAllCarros() {
        return em.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
    }

    public List<Acessorio> findAllAcessorios() {
        return em.createQuery("SELECT a FROM Acessorio a", Acessorio.class).getResultList();
    }

    //metodos de alteração
    public boolean atualizar(Object objeto) {
        try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    //metodo de exclusão
    public boolean excluir(Object objeto) {
        try {
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
