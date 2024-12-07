package paradigmas.theboys.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_batalha")
public class Batalha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batalhaId;

    @ManyToOne
    @JoinColumn(name = "heroi1_id", nullable = false)
    private Heroi heroi1;

    @ManyToOne
    @JoinColumn(name = "heroi2_id", nullable = false)
    private Heroi heroi2;

    private String resultado;

    @Column(nullable = false)
    private Integer vidaRestanteHeroi1;

    @Column(nullable = false)
    private Integer vidaRestanteHeroi2;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    public Batalha() {}

    public Batalha(Heroi heroi1, Heroi heroi2, String resultado, Integer vidaRestanteHeroi1, Integer vidaRestanteHeroi2) {
        this.heroi1 = heroi1;
        this.heroi2 = heroi2;
        this.resultado = resultado;
        this.vidaRestanteHeroi1 = vidaRestanteHeroi1;
        this.vidaRestanteHeroi2 = vidaRestanteHeroi2;
        this.dataHora = LocalDateTime.now();
    }

    public Integer getBatalhaId() {
        return batalhaId;
    }

    public void setBatalhaId(Integer batalhaId) {
        this.batalhaId = batalhaId;
    }

    public Heroi getHeroi1() {
        return heroi1;
    }

    public void setHeroi1(Heroi heroi1) {
        this.heroi1 = heroi1;
    }

    public Heroi getHeroi2() {
        return heroi2;
    }

    public void setHeroi2(Heroi heroi2) {
        this.heroi2 = heroi2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getVidaRestanteHeroi1() {
        return vidaRestanteHeroi1;
    }

    public void setVidaRestanteHeroi1(Integer vidaRestanteHeroi1) {
        this.vidaRestanteHeroi1 = vidaRestanteHeroi1;
    }

    public Integer getVidaRestanteHeroi2() {
        return vidaRestanteHeroi2;
    }

    public void setVidaRestanteHeroi2(Integer vidaRestanteHeroi2) {
        this.vidaRestanteHeroi2 = vidaRestanteHeroi2;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}