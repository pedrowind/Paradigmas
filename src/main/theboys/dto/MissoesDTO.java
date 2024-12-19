package paradigmas.theboys.dto;

import org.springframework.beans.BeanUtils;
import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.entities.Missoes;

public class MissoesDTO {

    private Integer missaoId;
    private String nomeMissao;
    private String descricaoMissao;;
    private Integer dificuldadeMissao;
    private String heroisDesignados;
    private String resultadoMissao;
    private String recompensaMissao;

    public MissoesDTO() {}

    public MissoesDTO(Missoes entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Integer getMissaoId() {
        return missaoId;
    }

    public void setMissaoId(Integer missaoId) {
        this.missaoId = missaoId;
    }

    public String getRecompensaMissao() {
        return recompensaMissao;
    }

    public void setRecompensaMissao(String recompensaMissao) {
        this.recompensaMissao = recompensaMissao;
    }

    public String getResultadoMissao() {
        return resultadoMissao;
    }

    public void setResultadoMissao(String resultadoMissao) {
        this.resultadoMissao = resultadoMissao;
    }

    public String getHeroisDesignados() {
        return heroisDesignados;
    }

    public void setHeroisDesignados(String heroisDesignados) {
        this.heroisDesignados = heroisDesignados;
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

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }
}
