package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TemId implements Serializable {
    private static final long serialVersionUID = -6074917418152923373L;
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "nome_cracha", nullable = false)
    private String nomeCracha;

    @Column(name = "id_game", nullable = false)
    private Character idGame;

    @Column(name = "nome_regiao", nullable = false)
    private String nomeRegiao;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNomeCracha() {
        return nomeCracha;
    }

    public void setNomeCracha(String nomeCracha) {
        this.nomeCracha = nomeCracha;
    }

    public Character getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemId entity = (TemId) o;
        return Objects.equals(this.idPlayer, entity.idPlayer) &&
                Objects.equals(this.nomeRegiao, entity.nomeRegiao) &&
                Objects.equals(this.nomeCracha, entity.nomeCracha) &&
                Objects.equals(this.idGame, entity.idGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRegiao, idGame , idPlayer, nomeCracha);
    }
}
