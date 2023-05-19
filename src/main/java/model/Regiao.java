package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regiao")
public class Regiao {
    @Id
    @Column(name = "nome_regiao", nullable = false, length = 10)
    private String nomeRegiao;

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    //TODO [JPA Buddy] generate columns from DB
}