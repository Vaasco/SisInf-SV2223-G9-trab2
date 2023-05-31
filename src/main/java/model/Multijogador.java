package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "multijogador")
public class Multijogador  {
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

    @OneToMany(mappedBy = "multijogador")
    private List<JogaMj> JogaMj;

    @ManyToOne
    @JoinColumn(name = "nome_regiao" , insertable = false , updatable = false)
    private Regiao regiaoMultijogador;

    @ManyToOne
    @JoinColumn(name = "id_game",insertable = false,updatable = false)
    private Jogos jogoMultijogador;

    public MultijogadorId getId(){
        return id;
    }

    void setMultijogadorId(MultijogadorId id){
        this.id = id;
    }

    public String getEstadoPartida(){
        return estadoPartida;
    }

    void setEstadoPartida(String estadoPartida){
        this.estadoPartida = estadoPartida;
    }

    public LocalTime getDataHoraInicio(){
        return dataHoraInicio;
    }

    void setDataHoraInicio(LocalTime dataHoraInicio){
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalTime getDataHoraFim(){
        return dataHoraInicio;
    }

    void setDataHoraFim(LocalTime dataHoraFim){
        this.dataHoraFim = dataHoraFim;
    }

    public Integer getIdPlayer(){
        return idPlayer;
    }

    void setIdPlayer(Integer idPlayer){
        this.idPlayer = idPlayer;
    }

    public Regiao getNomeRegiao() {
        return regiaoMultijogador;
    }

    void setNomeRegiao( Regiao regiaoMultijogador){
        this.regiaoMultijogador = regiaoMultijogador;
    }


    @Override
    public String toString(){
        return "Multijogador[" +
                "nome_regiao = "         + id.getNomeRegiao() +
                " , id_game = "             + id.getIdGame() +
                " , nmr_seq_partida = "     + id.getNmrSeqPartida() +
                " , estado_partida = "      + getEstadoPartida() +
                " , data_hora_inicio = "    + getDataHoraInicio() +
                " , data_hora_fim = "       + getDataHoraFim() +
                " , id_player = "           + getIdPlayer() +
                "]";
    }
}
