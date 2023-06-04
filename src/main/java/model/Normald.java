package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Normald implements Serializable {
    private static final long serialVersionUID = -3081338204084435959L;

    public Normald(String idGame, String nomeRegiao) {
        this.idGame = idGame;
        this.nomeRegiao = nomeRegiao;
    }


    @Column(name = "nome_regiao", nullable = false)
    private String nomeRegiao;

    @Column(name = "id_game", nullable = false)
    private String idGame;

    @Column(name = "nmr_seq_partida", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nmrSeqPartida;

    public Normald() {

    }


    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = String.valueOf(idGame);
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
        Normald entity = (Normald) o;
        return Objects.equals(this.nomeRegiao, entity.nomeRegiao) &&
                Objects.equals(this.idGame, entity.idGame) &&
                Objects.equals(this.nmrSeqPartida, entity.nmrSeqPartida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRegiao, idGame, nmrSeqPartida);
    }
}
