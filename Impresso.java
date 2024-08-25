public class Impresso extends Livro{
    private float frete;
    private int estoque;
    
    public Impresso(String titulo, float frete) {
        super(titulo);
        this.frete = frete;
        this.estoque = 0;
    }
    public Impresso(String titulo, float preco, float frete) {
        super(titulo, preco);
        this.frete = frete;
        this.estoque = 0;
    }
    public Impresso(String titulo, String autores, float preco, float frete) {
        super(titulo, autores, preco);
        this.frete = frete;
        this.estoque = 0;
    }
    public Impresso(String titulo, String autores, String editora, float preco, float frete) {
        super(titulo, autores, editora, preco);
        this.frete = frete;
        this.estoque = 0;
    }

    public void aumentarEstoque(){
        this.estoque++;
    }

    public boolean diminuirEstoque(){
        if (this.estoque > 0){
            this.estoque--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n\tFrete: " + this.frete + "\n\tEstoque: " + this.estoque);
    }

    public float getFrete() {
        return frete;
    }
    public void setFrete(float frete) {
        this.frete = frete;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    

}
