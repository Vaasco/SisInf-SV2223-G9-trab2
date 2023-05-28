package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComprarId implements Serializable {
    private static final long serialVersionUID = -2975386619020480208L;
    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    @Column(name = "nome_regiao", nullable = false, length = 30)
    private String nomeRegiao;

    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;


    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
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