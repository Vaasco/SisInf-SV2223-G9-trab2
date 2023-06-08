package model;

import jakarta.persistence.*;

import java.time.LocalTime;


@Entity
@Table(name = "normal")
public class Normal {

    @EmbeddedId
    private Normald id;

    @Column(name = "estado_partida")
    private String estadoPartida;

    @Column(name = "data_hora_inicio")
    private LocalTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalTime dataHoraFim;

    @Column(name = "pontuacao_n")
    private Integer pontuacaoN;

    @Column(name = "id_player")
    private Integer idPlayer;

    @Column(name = "grau_dificuldade")
    private Integer grauDificuldade;

    public Normal() {

    }

    public String getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(String estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public LocalTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Integer getPontuacaoN() {
        return pontuacaoN;
    }

    public void setPontuacaoN(Integer pontuacaoN) {
        this.pontuacaoN = pontuacaoN;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Integer getGrauDificuldade() {
        return grauDificuldade;
    }

    public void setGrauDificuldade(Integer grauDificuldade) {
        this.grauDificuldade = grauDificuldade;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_player", insertable = false, updatable = false)
    private Jogadores jogador;

    @ManyToOne
    @JoinColumn(name = "nome_regiao", insertable = false, updatable = false)
    private Regiao regiaoNormal;

    @ManyToOne
    @JoinColumn(name = "id_game", insertable = false, updatable = false)
    private Jogos jogoNormal;


    @Override
    public String toString() {
        return "Normal[" +
                "nome_regiao = " + id.getNomeRegiao() +
                " , id_game = " + id.getIdGame() +
                " , nmr_seq_partida = " + id.getNmrSeqPartida() +
                " , estado_partida = " + getEstadoPartida() +
                " , data_hora_inicio = " + getDataHoraInicio() +
                " , data_hora_fim = " + getDataHoraFim() +
                " , pontuacao_n = " + getPontuacaoN() +
                " , id_player = " + getIdPlayer() +
                " , grau_dificuldade = " + getGrauDificuldade() +
                "]";
    }
}
