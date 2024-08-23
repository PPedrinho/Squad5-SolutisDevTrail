public class Impresso extends Livro{

    public Impresso(){
        super();
    }

    public Impresso(String titulo){
        super(titulo);
    }

    public Impresso(String titulo, float preco){
        super(titulo, preco);
    }

    public Impresso(String titulo, String autores, float preco){
        super(titulo, autores, preco);
    }

    public Impresso(String titulo, String autores, String editora, float preco){
        super(titulo, autores, editora, preco);
    }

}
