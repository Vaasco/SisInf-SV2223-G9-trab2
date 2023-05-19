package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MensagenId implements Serializable {
    private static final long serialVersionUID = 5219174430912198314L;
    @Column(name = "id_conversa", nullable = false)
    private Integer idConversa;

    @Column(name = "nmr_seq_msg", nullable = false)
    private Integer nmrSeqMsg;

    public Integer getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Integer idConversa) {
        this.idConversa = idConversa;
    }

    public Integer getNmrSeqMsg() {
        return nmrSeqMsg;
    }

    public void setNmrSeqMsg(Integer nmrSeqMsg) {
        this.nmrSeqMsg = nmrSeqMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensagenId entity = (MensagenId) o;
        return Objects.equals(this.nmrSeqMsg, entity.nmrSeqMsg) &&
                Objects.equals(this.idConversa, entity.idConversa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmrSeqMsg, idConversa);
    }

}