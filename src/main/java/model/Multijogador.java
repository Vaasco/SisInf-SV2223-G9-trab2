package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "multijogador")
public class Multijogador {
    @EmbeddedId
    private MultijogadorId id;

    @Column(name = "estado_partida")
    private String estadoPartida;

    @Column(name = "data_hora_inicio")
    private LocalTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalTime dataHoraFim;

    @Column(name = "id_player")
    private Integer idPlayer;

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

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }
}
