package model;

import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.util.List;


@Entity
@Table(name = "regiao")
public class Regiao {
    @Id
    @Column(name = "nome_regiao")
    private String nomeRegiao;

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.PERSIST)
    private List<Jogadores> jogadores;

    @OneToMany(mappedBy = "regiaoNormal", cascade = CascadeType.PERSIST)
    private List<Normal> normal;

    @OneToMany(mappedBy = "regiaoMultijogador" , cascade = CascadeType.PERSIST)
    private List<Multijogador> multijogador;

    //todo como se liga regiao a partidas?


    @Override
    public String toString() {
        return "Regiao[" +
                "nome_regiao = " + getNomeRegiao() +
                "]";
    }
}
