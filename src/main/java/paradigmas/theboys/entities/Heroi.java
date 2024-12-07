package paradigmas.theboys.entities;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "tb_heroi")
public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer heroiId;

    private String nome;
    private Integer idade;
    private String sexo;
    private String caracteristicasFisicas;
    private Integer vida;
    private Integer energia;
    private Integer ataque;
    private Integer defesa;


    @Column(columnDefinition = "TEXT")
    private String poderes;
    private Integer forca;

    @Column(columnDefinition = "TEXT")
    private Integer popularidade;
    private String status;

    @Column(columnDefinition = "TEXT")
    private String historicoBatalhas;

    public Heroi() {}

    public Heroi(Integer heroiId, String nome, String historicoBatalhas, String status, Integer popularidade, Integer idade,
                 String sexo, String caracteristicasFisicas, String poderes, Integer forca,
                 Integer vida, Integer energia, Integer ataque, Integer defesa) {
        this.heroiId = heroiId;
        this.nome = nome;
        this.historicoBatalhas = historicoBatalhas;
        this.status = status;
        this.popularidade = popularidade;
        this.idade = idade;
        this.sexo = sexo;
        this.caracteristicasFisicas = caracteristicasFisicas;
        this.poderes = poderes;
        this.forca = forca;
        this.vida = vida;
        this.energia = energia;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public Integer getHeroiId() {
        return heroiId;
    }

    public void setHeroiId(Integer heroiId) {
        this.heroiId = heroiId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Heroi heroi = (Heroi) o;
        return Objects.equals(nome, heroi.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}