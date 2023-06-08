package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class ComprarId implements Serializable {

    private static final long serialVersionUID = 5648200503540246234L;

    @Column(name = "id_game", nullable = false)
    private Character idGame;
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "nome_regiao", nullable = false)
    private String nomeRegiao;

    public Character getIdGame() {
        return idGame;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprarId entity = (ComprarId) o;
        return Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.idPlayer, entity.idPlayer) &&
                Objects.equals(this.nomeRegiao, entity.nomeRegiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, idPlayer, nomeRegiao);
    }

}