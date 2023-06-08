package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AmigoId implements Serializable {

    private static final long serialVersionUID = -655725484378182258L;
    @Column(name = "id_player1", nullable = false , updatable = false)
    private Integer idPlayer1;

    @Column(name = "nome_regiao1", nullable = false)
    private String nomeRegiao1;

    @Column(name = "id_player2", nullable = false , updatable = false)
    private Integer idPlayer2;

    @Column(name = "nome_regiao2", nullable = false)
    private String nomeRegiao2;

    public Integer getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(Integer idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public String getNomeRegiao1() {
        return nomeRegiao1;
    }

    public void setNomeRegiao1(String nomeRegiao1) {
        this.nomeRegiao1 = nomeRegiao1;
    }

    public Integer getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(Integer idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    public String getNomeRegiao2() {
        return nomeRegiao2;
    }

    public void setNomeRegiao2(String nomeRegiao2) {
        this.nomeRegiao2 = nomeRegiao2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmigoId entity = (AmigoId) o;
        return Objects.equals(this.idPlayer1, entity.idPlayer1) &&
                Objects.equals(this.idPlayer2, entity.idPlayer2) &&
                Objects.equals(this.nomeRegiao1, entity.nomeRegiao1) &&
                Objects.equals(this.nomeRegiao2, entity.nomeRegiao2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer1, idPlayer2, nomeRegiao1, nomeRegiao2);
    }
}
