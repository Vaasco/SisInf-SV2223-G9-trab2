package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "regiao")
public class Regiao {
    @Id
    @Column(name = "nome_regiao", nullable = false, length = 10)
    private String nomeRegiao;

    @OneToMany(mappedBy="regiao", cascade = CascadeType.PERSIST )// não sei se é este o cascadeType indicado
    private List<Jogadore> jogadores;


    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    //TODO [JPA Buddy] generate columns from DB
}