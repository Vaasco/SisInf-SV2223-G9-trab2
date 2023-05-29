package model;

import jakarta.persistence.*;

@Entity
@Table(name = "estatisticas_jogadores")


public class estatisticas_jogadores {
    @Id
    private Integer id_player;

    @Column(name = "nmr_partidas_player")
    private Integer nmrPartidasPlayer;

    @Column(name = "nmr_jogos")
    private Integer nmrJogos;

    @Column(name = "total_pontos_player")
    private Integer totalPontosPlayer;


    public Integer getNmrPartidasPlayer(){
        return nmrPartidasPlayer;
    }

    public void setNmrPartidasPlayer(Integer nmrPartidasPlayer){
        this.nmrPartidasPlayer = nmrPartidasPlayer;
    }

    public Integer getNmrJogos(){
        return nmrJogos;
    }

    public void setNmrJogos(Integer nmrJogos) {
        this.nmrJogos = nmrJogos;
    }

    public Integer getTotalPontosPlayer() {
        return totalPontosPlayer;
    }

    public void setTotalPontosPlayer(Integer totalPontosPlayer) {
        this.totalPontosPlayer = totalPontosPlayer;
    }
}
