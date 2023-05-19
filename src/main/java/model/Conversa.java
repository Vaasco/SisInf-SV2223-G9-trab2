package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversas")
public class Conversa {
    @Id
    @Column(name = "id_conversa", nullable = false)
    private Integer id;

    @Column(name = "nome_conversa", length = 30)
    private String nomeConversa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeConversa() {
        return nomeConversa;
    }

    public void setNomeConversa(String nomeConversa) {
        this.nomeConversa = nomeConversa;
    }

}