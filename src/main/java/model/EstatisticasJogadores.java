package model;

import jakarta.persistence.*;
import orm.interfaces.IEstatisticasJogadores;

@Entity
@Table(name = "estatisticas_jogadores")
public class EstatisticasJogadores implements IEstatisticasJogadores {
    @Id
    private Integer id_player;

    @Column(name = "nmr_partidas_player")
    private Integer nmrPartidasPlayer;

    @Column(name = "nmr_jogos")
    private Integer nmrJogos;

    @Column(name = "total_pontos_player")
    private Integer totalPontosPlayer;

    @ManyToOne
    @JoinColumn(name = "id_player")

    private Jogadores jogador;


    public Integer getNmrPartidasPlayer() {
        return nmrPartidasPlayer;
    }

    public void setNmrPartidasPlayer(Integer nmrPartidasPlayer) {
        this.nmrPartidasPlayer = nmrPartidasPlayer;
    }

    public Integer getNmrJogos() {
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