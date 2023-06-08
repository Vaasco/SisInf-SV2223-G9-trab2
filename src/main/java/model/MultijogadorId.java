package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class MultijogadorId implements Serializable {

    private static final long serialVersionUID = 7849926518778318560L;
    @Column(name = "nome_regiao", nullable = false)
    private String nomeRegiao;

    @Column(name = "id_game", nullable = false)
    private Character idGame;

    @Column(name = "nmr_seq_partida", nullable = false)
    private Integer nmrSeqPartida;

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Character getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
    }

    public Integer getNmrSeqPartida() {
        return nmrSeqPartida;
    }

    public void setNmrSeqPartida(Integer nmrSeqPartida) {
        this.nmrSeqPartida = nmrSeqPartida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultijogadorId entity = (MultijogadorId) o;
        return Objects.equals(this.nomeRegiao, entity.nomeRegiao) &&
                Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nmrSeqPartida, entity.nmrSeqPartida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRegiao, idGame, nmrSeqPartida);
    }
}
