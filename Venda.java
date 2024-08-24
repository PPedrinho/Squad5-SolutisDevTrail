import java.util.ArrayList;
import java.util.List;

public class Venda {
    private ArrayList<Livro> livros;
    private static int numVendas;
    private int numero;
    private String cliente;
    private float valor;

    //construtoress
    public Venda() {    

    }

    public Venda(String cliente, ArrayList<Livro> livros, float valor) {
        this.numVendas = 0;
        this.numero = ++numVendas;
        this.cliente = cliente;
        this.valor = valor;
        this.livros = new ArrayList<>(livros);
    }
    

    //metodos
    public void addLivro(Livro l, int index) {
        livros.add(index, l);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }

    //get e set
    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    



}
