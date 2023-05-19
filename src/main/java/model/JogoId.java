package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JogoId implements Serializable {
    private static final long serialVersionUID = 7575455522405702358L;
    @Column(name = "nome_game", nullable = false, length = 30)
    private String nomeGame;

    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    public String getNomeGame() {
        return nomeGame;
    }

    public void setNomeGame(String nomeGame) {
        this.nomeGame = nomeGame;
    }

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoId entity = (JogoId) o;
        return Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nomeGame, entity.nomeGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, nomeGame);
    }

}