package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mensagens")
public class Mensagen {
    @EmbeddedId
    private MensagenId id;

    @MapsId("idConversa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_conversa", nullable = false)
    private Conversa idConversa;

    @Column(name = "texto", length = 50)
    private String texto;

    @Column(name = "remetente", length = 30)
    private String remetente;

    @Column(name = "data_hora_msg")
    private LocalDate dataHoraMsg;

    public MensagenId getId() {
        return id;
    }

    public void setId(MensagenId id) {
        this.id = id;
    }

    public Conversa getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Conversa idConversa) {
        this.idConversa = idConversa;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public LocalDate getDataHoraMsg() {
        return dataHoraMsg;
    }

    public void setDataHoraMsg(LocalDate dataHoraMsg) {
        this.dataHoraMsg = dataHoraMsg;
    }

}