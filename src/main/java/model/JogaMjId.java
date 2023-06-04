package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JogaMjId implements Serializable {
    private static final long serialVersionUID = 8481544358552495899L;
    @Column(name = "nmr_seq_partida", nullable = false)
    private Integer nmrSeqPartida;

    @Column(name = "id_game", nullable = false)
    private Integer idGame;

    @Column(name = "nome_regiao", nullable = false, length = 30)
    private String nomeRegiao;

    @Column(name = "nome_game", nullable = false, length = 30)
    private String nomeGame;

    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    public Integer getNmrSeqPartida() {
        return nmrSeqPartida;
    }

    public void setNmrSeqPartida(Integer nmrSeqPartida) {
        this.nmrSeqPartida = nmrSeqPartida;
    }

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

    public String getNomeGame() {
        return nomeGame;
    }

    public void setNomeGame(String nomeGame) {
        this.nomeGame = nomeGame;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
}