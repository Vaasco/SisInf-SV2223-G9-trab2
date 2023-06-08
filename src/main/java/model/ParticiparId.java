package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticiparId implements Serializable {

    private static final long serialVersionUID = 5838661715150276220L;
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "nome_regiao", nullable = false)
    private String nomeRegiao;

    @Column(name = "id_conversa", nullable = false)
    private Integer idConversa;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Integer getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Integer idConversa) {
        this.idConversa = idConversa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticiparId entity = (ParticiparId) o;
        return Objects.equals(this.idPlayer, entity.idPlayer) &&
                Objects.equals(this.idConversa, entity.idConversa) &&
                Objects.equals(this.nomeRegiao, entity.nomeRegiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRegiao, idConversa, idPlayer);
    }
}