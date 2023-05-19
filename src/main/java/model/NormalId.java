package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NormalId implements Serializable {
    private static final long serialVersionUID = 7298530406842094978L;
    @Column(name = "nome_regiao", nullable = false, length = 10)
    private String nomeRegiao;

    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    @Column(name = "nome_game", nullable = false, length = 30)
    private String nomeGame;

    @Column(name = "nmr_seq_partida", nullable = false)
    private Integer nmrSeqPartida;

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

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
        NormalId entity = (NormalId) o;
        return Objects.equals(this.nomeRegiao, entity.nomeRegiao) &&
                Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nmrSeqPartida, entity.nmrSeqPartida) &&
                Objects.equals(this.nomeGame, entity.nomeGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRegiao, idGame, nmrSeqPartida, nomeGame);
    }

}