package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "conversas")
public class Conversa {

    @Id
    @Column(name = "id_conversa", nullable = false)
    private Integer id;

    @Column(name = "nome_conversa", length = 30)
    private String nomeConversa;

    @OneToMany(mappedBy = "conversa", cascade = CascadeType.PERSIST)
    private List<Mensagen> mensagens;

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