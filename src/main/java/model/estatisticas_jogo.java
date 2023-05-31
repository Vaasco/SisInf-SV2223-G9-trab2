package model;


import jakarta.persistence.*;
import orm.interfaces.IEstatisticasJogo;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_game", insertable = false, updatable = false)
    private Jogos jogo;


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
    @Override
    public String toString() {
        return "EstatisticasJogo[" +
                "id_game = " + getIdGame() +
                " , nmr_partidas_game = " + getNmrPartidasGame() +
                " , nmr_players = " + getNmrPlayers() +
                " , total_pontos_game = " + getTotalPontosGame() +
                "]";
    }
}
