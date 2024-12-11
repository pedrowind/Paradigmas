package paradigmas.theboys.dto;

import org.springframework.beans.BeanUtils;
import paradigmas.theboys.entities.Crimes;

import java.util.Date;

public class CrimesDTO {

    private Integer crimeId;
    private String nomeCrime;
    private String descricaoCrime;
    private Date dataCrime;
    private String heroiResponsavel;
    private Integer severidadeCrime;

    public CrimesDTO() {
    }

    public CrimesDTO(Crimes entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Integer getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Integer crimeId) {
        this.crimeId = crimeId;
    }

    public Integer getSeveridadeCrime() {
        return severidadeCrime;
    }

    public void setSeveridadeCrime(Integer severidadeCrime) {
        this.severidadeCrime = severidadeCrime;
    }

    public String getHeroiResponsavel() {
        return heroiResponsavel;
    }

    public void setHeroiResponsavel(String heroiResponsavel) {
        this.heroiResponsavel = heroiResponsavel;
    }

    public Date getDataCrime() {
        return dataCrime;
    }

    public void setDataCrime(Date dataCrime) {
        this.dataCrime = dataCrime;
    }

    public String getDescricaoCrime() {
        return descricaoCrime;
    }

    public void setDescricaoCrime(String descricaoCrime) {
        this.descricaoCrime = descricaoCrime;
    }

    public String getNomeCrime() {
        return nomeCrime;
    }

    public void setNomeCrime(String nomeCrime) {
        this.nomeCrime = nomeCrime;
    }
}