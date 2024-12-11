package paradigmas.theboys.entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "tb_missoes")
public class Missoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missaoId;
    private String nomeMissao;

    @Column(columnDefinition = "TEXT")
    private String descricaoMissao;;
    private Integer dificuldadeMissao;
    private String heroisDesignados;
    private String resultadoMissao;
    private String recompensaMissao;

    public Missoes() {}

    public Missoes(Integer missaoId, String nomeMissao, String recompensaMissao, String resultadoMissao, String heroisDesignados,
                   Integer dificuldadeMissao, String descricaoMissao) {
        this.missaoId = missaoId;
        this.nomeMissao = nomeMissao;
        this.recompensaMissao = recompensaMissao;
        this.resultadoMissao = resultadoMissao;
        this.heroisDesignados = heroisDesignados;
        this.dificuldadeMissao = dificuldadeMissao;
        this.descricaoMissao = descricaoMissao;
    }

    public Integer getMissaoId() {
        return missaoId;
    }

    public void setId(Integer missaoId) {
        this.missaoId = missaoId;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getRecompensaMissao() {
        return recompensaMissao;
    }

    public void setRecompensaMissao(String recompensaMissao) {
        this.recompensaMissao = recompensaMissao;
    }

    public String getHeroisDesignados() {
        return heroisDesignados;
    }

    public void setHeroisDesignados(String heroisDesignados) {
        this.heroisDesignados = heroisDesignados;
    }

    public String getResultadoMissao() {
        return resultadoMissao;
    }

    public void setResultadoMissao(String resultadoMissao) {
        this.resultadoMissao = resultadoMissao;
    }

    public Integer getDificuldadeMissao() {
        return dificuldadeMissao;
    }

    public void setDificuldadeMissao(Integer dificuldadeMissao) {
        this.dificuldadeMissao = dificuldadeMissao;
    }

    public String getDescricaoMissao() {
        return descricaoMissao;
    }

    public void setDescricaoMissao(String descricaoMissao) {
        this.descricaoMissao = descricaoMissao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Missoes missoes = (Missoes) o;
        return Objects.equals(missoes, missoes.missaoId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(missaoId);
    }
}
