package model;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table
public class Mensagens {

    @EmbeddedId
    private MensagensId id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "remetente")
    private Integer remetente;

    @Column(name = "regiao_remetente")
    private String regiaoRemetente;

    @Column(name = "data_hora_msg")
    private LocalTime dataHoraMsg;

    public MensagensId getId() {
        return id;
    }

    public void setId(MensagensId id) {
        this.id = id;
    }

    public Integer getRemetente() {
        return remetente;
    }

    public void setRemetente(Integer remetente) {
        this.remetente = remetente;
    }

    public String getRegiaoRemetente() {
        return regiaoRemetente;
    }

    public void setRegiaoRemetente(String regiaoRemetente) {
        this.regiaoRemetente = regiaoRemetente;
    }

    public LocalTime getDataHoraMsg() {
        return dataHoraMsg;
    }

    public void setDataHoraMsg(LocalTime dataHoraMsg) {
        this.dataHoraMsg = dataHoraMsg;
    }

}
