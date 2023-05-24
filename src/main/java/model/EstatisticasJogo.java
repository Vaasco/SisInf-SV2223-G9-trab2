package model;

import jakarta.persistence.*;
import orm.interfaces.IEstatisticasJogadores;
import orm.interfaces.IEstatisticasJogo;

@Entity
@Table(name = "estatisticas_jogo")
public class EstatisticasJogo implements IEstatisticasJogo {
    @Id
    private Integer id;

    @Column(name = "total_pontos_game")
    private Integer totalPontosGame;

    @Column(name = "nmr_players")
    private Integer nmrPlayers;

    @Column(name = "nmr_partidas_game")
    private Integer nmrPartidasGame;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Jogos jogos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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