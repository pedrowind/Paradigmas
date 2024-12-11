package paradigmas.theboys.dto;

import org.springframework.beans.BeanUtils;
import paradigmas.theboys.entities.Heroi;

public class HeroiDTO {

    private Integer heroiId;
    private String nome;
    private Integer idade;
    private String sexo;
    private String caracteristicasFisicas;
    private String poderes;
    private Integer forca;
    private Integer popularidade;
    private String status;
    private String historicoBatalhas;

    public HeroiDTO() {}

    public HeroiDTO(Heroi entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Integer getHeroiId() {
        return heroiId;
    }

    public void setHeroiId(Integer heroiId) {
        this.heroiId = heroiId;
    }

    public String getHistoricoBatalhas() {
        return historicoBatalhas;
    }

    public void setHistoricoBatalhas(String historicoBatalhas) {
        this.historicoBatalhas = historicoBatalhas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Integer popularidade) {
        this.popularidade = popularidade;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public String getPoderes() {
        return poderes;
    }

    public void setPoderes(String poderes) {
        this.poderes = poderes;
    }

    public String getCaracteristicasFisicas() {
        return caracteristicasFisicas;
    }

    public void setCaracteristicasFisicas(String caracteristicasFisicas) {
        this.caracteristicasFisicas = caracteristicasFisicas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
