package paradigmas.theboys.dto;

import paradigmas.theboys.entities.Batalha;

import java.time.LocalDateTime;

public class BatalhaDTO {

    private Integer batalhaId;
    private Integer heroi1Id;
    private Integer heroi2Id;
    private String resultado;
    private Integer vidaRestanteHeroi1;
    private Integer vidaRestanteHeroi2;
    private LocalDateTime dataHora;

    public BatalhaDTO() {}

    public BatalhaDTO(Batalha batalha) {
        this.batalhaId = batalha.getBatalhaId();
        this.heroi1Id = batalha.getHeroi1().getHeroiId();
        this.heroi2Id = batalha.getHeroi2().getHeroiId();
        this.resultado = batalha.getResultado();
        this.vidaRestanteHeroi1 = batalha.getVidaRestanteHeroi1();
        this.vidaRestanteHeroi2 = batalha.getVidaRestanteHeroi2();
        this.dataHora = batalha.getDataHora();
    }

    public Integer getBatalhaId() {
        return batalhaId;
    }

    public void setBatalhaId(Integer batalhaId) {
        this.batalhaId = batalhaId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getVidaRestanteHeroi2() {
        return vidaRestanteHeroi2;
    }

    public void setVidaRestanteHeroi2(Integer vidaRestanteHeroi2) {
        this.vidaRestanteHeroi2 = vidaRestanteHeroi2;
    }

    public Integer getVidaRestanteHeroi1() {
        return vidaRestanteHeroi1;
    }

    public void setVidaRestanteHeroi1(Integer vidaRestanteHeroi1) {
        this.vidaRestanteHeroi1 = vidaRestanteHeroi1;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getHeroi2Id() {
        return heroi2Id;
    }

    public void setHeroi2Id(Integer heroi2Id) {
        this.heroi2Id = heroi2Id;
    }

    public Integer getHeroi1Id() {
        return heroi1Id;
    }

    public void setHeroi1Id(Integer heroi1Id) {
        this.heroi1Id = heroi1Id;
    }
}