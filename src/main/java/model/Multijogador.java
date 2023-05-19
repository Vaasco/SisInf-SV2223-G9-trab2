package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "multijogador")
public class Multijogador {
    @EmbeddedId
    private MultijogadorId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "id_game", referencedColumnName = "id_game", nullable = false),
            @JoinColumn(name = "nome_game", referencedColumnName = "nome_game", nullable = false)
    })
    private Jogo jogos;

    @Column(name = "estado_partida", length = 30)
    private String estadoPartida;

    @Column(name = "data_hora_inicio")
    private LocalDate dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDate dataHoraFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_player", referencedColumnName = "id_player"),
            @JoinColumn(name = "username", referencedColumnName = "username"),
            @JoinColumn(name = "email", referencedColumnName = "email")
    })
    private Jogadore jogadores;

    public MultijogadorId getId() {
        return id;
    }

    public void setId(MultijogadorId id) {
        this.id = id;
    }

    public Jogo getJogos() {
        return jogos;
    }

    public void setJogos(Jogo jogos) {
        this.jogos = jogos;
    }

    public String getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(String estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public LocalDate getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDate dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDate getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDate dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Jogadore getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogadore jogadores) {
        this.jogadores = jogadores;
    }

}