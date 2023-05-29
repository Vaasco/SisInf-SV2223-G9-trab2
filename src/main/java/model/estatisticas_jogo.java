package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estatisticas_jogo")
public class estatisticas_jogo {

    @Id
    @Column(name = "id_game")
    private Character idGame;

    @Column(name = "nmr_partidas_game")
    private Integer nmrPartidasGame;

    @Column(name = "nmr_players")
    private Integer nmrPlayers;

    @Column(name = "total_pontos_game")
    private Integer totalPontosGame;

    public Character getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
    }

    public Integer getNmrPartidasGame() {
        return nmrPartidasGame;
    }

    public void setNmrPartidasGame(Integer nmrPartidasGame) {
        this.nmrPartidasGame = nmrPartidasGame;
    }

    public Integer getNmrPlayers() {
        return nmrPlayers;
    }

    public void setNmrPlayers(Integer nmrPlayers) {
        this.nmrPlayers = nmrPlayers;
    }

    public Integer getTotalPontosGame() {
        return totalPontosGame;
    }

    public void setTotalPontosGame(Integer totalPontosGame) {
        this.totalPontosGame = totalPontosGame;
    }
}
