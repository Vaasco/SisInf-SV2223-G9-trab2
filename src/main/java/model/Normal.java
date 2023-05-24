package model;

import jakarta.persistence.*;
import orm.interfaces.INormal;

import java.time.LocalDate;


@Entity
@Table(name = "normal")
public class Normal implements INormal {
    @EmbeddedId
    private NormalId id;

    @ManyToOne
    @JoinColumn(name = "nome_regiao")
    private Regiao regiao;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_game", nullable = false)
    private Jogos jogos;

    @Column(name = "estado_partida", length = 30)
    private String estadoPartida;

    @Column(name = "data_hora_inicio")
    private LocalDate dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDate dataHoraFim;

    @Column(name = "pontuacao_n")
    private Integer pontuacaoN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_player", referencedColumnName = "id_player")
    private Jogadores jogadores;

    @Column(name = "grau_dificuldade")
    private Integer grauDificuldade;


    public NormalId getId() {
        return id;
    }

    public void setId(NormalId id) {
        this.id = id;
    }

    public Regiao getNomeRegiao() {
        return regiao;
    }

    public void setNomeRegiao(Regiao nomeRegiao) {
        this.regiao = nomeRegiao;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
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

    public Integer getPontuacaoN() {
        return pontuacaoN;
    }

    public void setPontuacaoN(Integer pontuacaoN) {
        this.pontuacaoN = pontuacaoN;
    }

    public Jogadores getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogadores jogadores) {
        this.jogadores = jogadores;
    }

    public Integer getGrauDificuldade() {
        return grauDificuldade;
    }

    public void setGrauDificuldade(Integer grauDificuldade) {
        this.grauDificuldade = grauDificuldade;
    }
}