import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaCausasNaturais;
    private Boolean protecaoRoubo;

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public Boolean getProtecaCausasNaturais() {
        return protecaCausasNaturais;
    }

    public void setProtecaCausasNaturais(Boolean protecaCausasNaturais) {
        this.protecaCausasNaturais = protecaCausasNaturais;
    }

    public Boolean getProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(Boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @OneToOne(mappedBy = "apolice")
    private Aluguel aluguel;


}