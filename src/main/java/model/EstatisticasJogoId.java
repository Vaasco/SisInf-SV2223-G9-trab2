package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstatisticasJogoId implements Serializable {
    private static final long serialVersionUID = 2593211847167114277L;
    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    @Column(name = "nome_game", nullable = false, length = 30)
    private String nomeGame;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstatisticasJogoId entity = (EstatisticasJogoId) o;
        return Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nomeGame, entity.nomeGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, nomeGame);
    }

}