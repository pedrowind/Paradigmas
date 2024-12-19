package paradigmas.theboys.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "tb_crimes")
public class Crimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crimeId;
    private String nomeCrime;

    @Column(columnDefinition = "TEXT")
    private String descricaoCrime;
    private Date dataCrime;
    private String heroiResponsavel;
    private Integer severidadeCrime;

    public Crimes () {}

    public Crimes(Integer crimeId, String nomeCrime, Integer severidadeCrime, String descricaoCrime, Date dataCrime, String heroiResponsavel) {
        this.crimeId = crimeId;
        this.nomeCrime = nomeCrime;
        this.severidadeCrime = severidadeCrime;
        this.descricaoCrime = descricaoCrime;
        this.dataCrime = dataCrime;
        this.heroiResponsavel = heroiResponsavel;
    }

    public Integer getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Integer id) {
        this.crimeId = id;
    }

    public String getNomeCrime() {
        return nomeCrime;
    }

    public void setNomeCrime(String nomeCrime) {
        this.nomeCrime = nomeCrime;
    }

    public Integer getSeveridadeCrime() {
        return severidadeCrime;
    }

    public void setSeveridadeCrime(Integer severidadeCrime) {
        this.severidadeCrime = severidadeCrime;
    }

    public String getheroiResponsavel() {
        return heroiResponsavel;
    }

    public void setheroiResponsavel(String heroiResponsavel) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Crimes crimes = (Crimes) o;
        return Objects.equals(crimes, crimes.crimeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crimeId);
    }
}
