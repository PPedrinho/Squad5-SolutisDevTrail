import java.util.Scanner;

public class LivrariaVirtual {
    private final int MAX_IMPRESSOS = 50;
    private final int MAX_ELETRONICOS = 50;
    private final int MAX_VENDAS = 100;
    private Impresso[] impressos;
    private Eletronico[] eletronicos;
    private Venda[] vendas;
    private int numImpressos;
    private int numEletronicos;
    private int numVendas;

    public LivrariaVirtual() {
        this.impressos = new Impresso[MAX_IMPRESSOS];
        this.eletronicos = new Eletronico[MAX_ELETRONICOS];
        this.vendas = new Venda[MAX_VENDAS];
        this.numImpressos = 0;
        this.numEletronicos = 0;
        this.numVendas = 0;
    }

    public int impressoExistente(Impresso i) {
        for (int j = 0; j < numImpressos; j++) {
            if (impressos[j].equals(i)) {
                return j;
            }
        }
        return -1;
    }

    public boolean eletronicoIgual(Eletronico e, Eletronico e2) {
        return e2.getTitulo().equals(e.getTitulo()) && e2.getAutores().equals(e.getAutores()) && e2.getPreco() == e.getPreco() && e2.getEditora().equals(e.getEditora()) && e2.getTamanho() == e.getTamanho();
    }

    public int eletronicoExistente(Eletronico e) {
        for (int j = 0; j < numEletronicos; j++) {
            if (eletronicoIgual(eletronicos[j], e)) {
                System.out.println("Livro ja existe!");
                return j;
            }
        }
        return -1;
    }

    public boolean addEletronico(Eletronico e) {
        if (eletronicoExistente(e) != -1) // verifica se o eletronico ja existe
            return true; // retorna true se o eletronico ja existe, não adicionando um novo
        if (numEletronicos < MAX_ELETRONICOS) {
            eletronicos[numEletronicos] = e;
            numEletronicos++;
            return true;
        }
        return false;
    }

    public boolean addAmbos(Impresso i, Eletronico e) {
        if (numImpressos < MAX_IMPRESSOS && numEletronicos < MAX_ELETRONICOS) {
            addEletronico(e);
            //addImpresso(i);
            return true;
        }
        return false;
    }

    public boolean addVenda(Venda v) {
        if (numVendas < MAX_VENDAS) {
            vendas[numVendas] = v;
            numVendas++;
            return true;
        }
        return false;
    }

    public void cadastrarLivro(Scanner sc){
        int tipo = 0;
        while (tipo != 1 && tipo != 2 && tipo != 3) { 
            System.out.println("Digite o tipo de livro que deseja cadastrar:");
            System.out.println("1. Impresso");
            System.out.println("2. Eletrônico");
            System.out.println("3. Ambos");
            System.out.print("\n-> ");
            tipo = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite o titulo do livro: ");
            //colocar verificação se livro existe nos livros cadastrados
            String titulo = sc.nextLine();
            System.out.println("Digite o(s) autor(es) do livro: ");
            String autor = sc.nextLine();
            System.out.println("Digite a editora do livro: ");
            String editora = sc.nextLine();
            System.out.println("Digite o preço do livro: ");
            float preco = sc.nextFloat();
            sc.nextLine();
            
            if (tipo == 1) {
                System.out.println("Digite o frete cobrado para entrega do livro:");
                float frete = sc.nextFloat();
                //addImpresso(new Impresso(titulo, autor, editora, preco, frete));
            } else if (tipo == 2) {
                System.out.println("Digite o tamanho do arquivo (em KB):");
                int tamanho = sc.nextInt();
                addEletronico(new Eletronico(titulo, autor, editora, preco, tamanho));
            } else if (tipo == 3) {
                System.out.println("Digite o frete cobrado para entrega do livro:");
                float frete = sc.nextFloat();
                System.out.println("Digite o tamanho do arquivo (em KB):");
                int tamanho = sc.nextInt();
                System.out.println(tipo);
                //addImpresso(new Impresso(titulo, autor, editora, preco, frete));
                addEletronico(new Eletronico(titulo, autor, editora, preco, tamanho));
            } else {
                System.out.println("Opcão inválida. Tente novamente.\n");
            }
        }
    }

    public void listarLivrosEletronicos(){
        System.out.println("\nLIVROS ELETRÕNICOS CADASTRADOS:\n");
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println((i + 1) + ". {");
            System.out.println(eletronicos[i]);
            System.out.println("}\n");
        }
    }

    public void listarLivrosImpressos(){

    }

    public void listarLivros(){
        listarLivrosImpressos();
        listarLivrosEletronicos();
    }

    public void listarVendas(){

    }

    public int getMAX_IMPRESSOS() {
        return MAX_IMPRESSOS;
    }

    public int getMAX_ELETRONICOS() {
        return MAX_ELETRONICOS;
    }

    public int getMAX_VENDAS() {
        return MAX_VENDAS;
    }

    public Impresso[] getImpressos() {
        return impressos;
    }

    public void setImpressos(Impresso[] impressos) {
        this.impressos = impressos;
    }

    public Eletronico[] getEletronicos() {
        return eletronicos;
    }

    public void setEletronicos(Eletronico[] eletronicos) {
        this.eletronicos = eletronicos;
    }

    public Venda[] getVendas() {
        return vendas;
    }

    public void setVendas(Venda[] vendas) {
        this.vendas = vendas;
    }

    public int getNumImpressos() {
        return numImpressos;
    }

    public void setNumImpressos(int numImpressos) {
        this.numImpressos = numImpressos;
    }

    public int getNumEletronicos() {
        return numEletronicos;
    }

    public void setNumEletronicos(int numEletronicos) {
        this.numEletronicos = numEletronicos;
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner sc = new Scanner(System.in);
        livraria.cadastrarLivro(sc);
        livraria.cadastrarLivro(sc);
        livraria.listarLivrosEletronicos();
        sc.close();
    }
}