package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Conversas")
public class Conversas {
    @Id
    @Column(name = "id_conversa")
    private Integer idConversa;

    @Column(name = "nome_conversa")
    private String nomeConversa;

    public Integer getIdConversa() {
        return idConversa;
    }

    public void setId(Integer idConversa) {
        this.idConversa = idConversa;
    }

    public String getNomeConversa() {
        return nomeConversa;
    }

    public void setNomeConversa(String nomeConversa) {
        this.nomeConversa = nomeConversa;
    }
}
