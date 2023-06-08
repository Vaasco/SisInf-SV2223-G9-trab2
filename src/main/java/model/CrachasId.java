package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class CrachasId implements Serializable {

    private static final long serialVersionUID = -3782802734831814999L;

    public CrachasId(String idGame, String nomeCracha) {
        this.idGame = idGame;
        this.nomeCracha = nomeCracha;
    }

    @Column(name = "id_game", nullable = false)
    private String idGame;

    @Column(name = "nome_cracha", nullable = false)
    private String nomeCracha;

    public CrachasId() {

    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = String.valueOf(idGame);
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
        CrachasId entity = (CrachasId) o;
        return Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nomeCracha, entity.nomeCracha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, nomeCracha);
    }
}
