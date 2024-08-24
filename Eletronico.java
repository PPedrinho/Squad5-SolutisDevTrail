public class Eletronico extends Livro {
    private int tamanho;

    public Eletronico(String titulo, String autores, String editora, float preco, int tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamanho do arquivo: " + (tamanho > 0 ? tamanho + " KB" : "não informado");
    }
}