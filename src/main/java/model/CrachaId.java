package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CrachaId implements Serializable {
    private static final long serialVersionUID = 551170741717162794L;
    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    @Column(name = "nome_game", nullable = false, length = 30)
    private String nomeGame;

    @Column(name = "nome_cracha", nullable = false, length = 30)
    private String nomeCracha;

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public String getNomeGame() {
        return nomeGame;
    }

    public void setNomeGame(String nomeGame) {
        this.nomeGame = nomeGame;
    }

    public String getNomeCracha() {
        return nomeCracha;
    }

    public void setNomeCracha(String nomeCracha) {
        this.nomeCracha = nomeCracha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrachaId entity = (CrachaId) o;
        return Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nomeCracha, entity.nomeCracha) &&
                Objects.equals(this.nomeGame, entity.nomeGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, nomeCracha, nomeGame);
    }

}