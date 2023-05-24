package model;

import jakarta.persistence.*;
import orm.interfaces.IRegiao;

import java.util.List;


@Entity
@Table(name = "regiao")
public class Regiao implements IRegiao {
    @Id
    @Column(name = "nome_regiao", nullable = false, length = 40)
    private String nomeRegiao;


    @OneToMany(mappedBy="regiao", cascade = CascadeType.PERSIST )   // não sei se é este o cascadeType indicado
    private List<Jogadores> jogadores;

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.PERSIST)  // não sei se é este o cascadeType indicado
    private List<Normal> normal;

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.PERSIST)  // não sei se é este o cascadeType indicado
    private List<Multijogador> multijogador;


    public String getNomeRegiao() {
        return nomeRegiao;
    }


    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    //TODO [JPA Buddy] generate columns from DB
}