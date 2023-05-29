package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.xml.namespace.QName;
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
}
