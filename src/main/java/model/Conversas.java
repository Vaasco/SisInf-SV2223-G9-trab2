package model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Conversas")
public class Conversas {

    @Id
    @Column(name = "id_conversa")
    private Integer idConversa;

    @Column(name = "nome_conversa")
    private String nomeConversa;

    @OneToMany(mappedBy = "conversa")
    private List<Mensagens> mensagens;

    @OneToMany(mappedBy = "conversa")
    private List<Participar> participar;


    public Integer getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Integer idConversa) {
        this.idConversa = idConversa;
    }

    public String getNomeConversa() {
        return nomeConversa;
    }

    public void setNomeConversa(String nomeConversa) {
        this.nomeConversa = nomeConversa;
    }


    @Override
    public String toString() {
        return "Conversas[" +
                "id_conversa = " + idConversa +
                ", nome_conversa = " + getNomeConversa() +
                "]";
    }
}
