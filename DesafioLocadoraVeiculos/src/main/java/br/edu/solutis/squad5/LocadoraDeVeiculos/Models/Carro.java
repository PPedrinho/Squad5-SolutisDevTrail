
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private List<Acessorio> acessorios = new ArrayList<>();

    public Carro(String placa, String chassi, String cor, BigDecimal valorDiaria) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        acessorios.add(acessorio);
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    // Getters simples
    public String getPlaca() { return placa; }
    public String getChassi() { return chassi; }
    public String getCor() { return cor; }
    public BigDecimal getValorDiaria() { return valorDiaria; }
}
