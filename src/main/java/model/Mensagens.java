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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conversa", insertable = false, updatable = false)
    private Conversas conversa;


    public Integer getRemetente() {
        return remetente;
    }


    public void setRegiaoRemetente(String regiaoRemetente) {
        this.regiaoRemetente = regiaoRemetente;
    }


    public void setRemetente(Integer remetente) {
        this.remetente = remetente;
    }


    public String getRegiaoRemetente() {
        return regiaoRemetente;
    }


    public LocalTime getDataHoraMsg() {
        return dataHoraMsg;
    }


    public void setId(MensagensId id) {
        this.id = id;
    }


    public void setDataHoraMsg(LocalTime dataHoraMsg) {
        this.dataHoraMsg = dataHoraMsg;
    }


    public MensagensId getId() {
        return id;
    }


    public String getTexto() {
        return texto;
    }


    public void setTexto(String texto) {
        this.texto = texto;
    }


    @Override
    public String toString() {
        return "Mensagens[" +
                "id_conversa = " + id.getIdConversa() +
                " , nmr_seq_msg = " + id.getNmrSeqMsg() +
                " , texto = " + getTexto() +
                " , remetente = " + getRemetente() +
                " , regiao_remetente = " + getRegiaoRemetente() +
                " , data_hora_msm = " + getDataHoraMsg() +
                "]";
    }
}
