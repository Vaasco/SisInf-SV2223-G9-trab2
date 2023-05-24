package model;

import jakarta.persistence.*;
import orm.interfaces.IConversa;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conversas")
public class Conversa implements IConversa {

    @Id
    @Column(name = "id_conversa", nullable = false)
    private Integer id;

    @Column(name = "nome_conversa", length = 30)
    private String nomeConversa;

    @OneToMany(mappedBy = "conversa", cascade = CascadeType.PERSIST)
    private List<Mensagens> mensagens;

    @ManyToMany(mappedBy = "conversas", cascade = CascadeType.REMOVE)
    private Set<Jogadores> jogadores;

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