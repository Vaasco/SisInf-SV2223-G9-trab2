package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CrachasId implements Serializable {

    private static final long serialVersionUID = -3782802734831814999L;
    @Column(name = "id_game", nullable = false )
    private Character idGame;

    @Column(name = "nome_cracha" , nullable = false)
    private String nomeCracha;

    public Character getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
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
