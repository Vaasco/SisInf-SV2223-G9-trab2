package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "estatisticas_jogo")
public class EstatisticasJogo {
    @EmbeddedId
    private EstatisticasJogoId id;

    @Column(name = "total_pontos_game")
    private Integer totalPontosGame;

    @Column(name = "nmr_players")
    private Integer nmrPlayers;

    @Column(name = "nmr_partidas_game")
    private Integer nmrPartidasGame;

    public EstatisticasJogoId getId() {
        return id;
    }

    public void setId(EstatisticasJogoId id) {
        this.id = id;
    }

    public Integer getTotalPontosGame() {
        return totalPontosGame;
    }

    public void setTotalPontosGame(Integer totalPontosGame) {
        this.totalPontosGame = totalPontosGame;
    }

    public Integer getNmrPlayers() {
        return nmrPlayers;
    }

    public void setNmrPlayers(Integer nmrPlayers) {
        this.nmrPlayers = nmrPlayers;
    }

    public Integer getNmrPartidasGame() {
        return nmrPartidasGame;
    }

    public void setNmrPartidasGame(Integer nmrPartidasGame) {
        this.nmrPartidasGame = nmrPartidasGame;
    }

}