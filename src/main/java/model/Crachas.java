package model;

import jakarta.persistence.*;
import orm.interfaces.ICrachas;

import java.util.Set;


//acho que falta o nome_cracha!!!
@Entity
@Table(name = "crachas")
public class Crachas implements ICrachas {
    @EmbeddedId
    private CrachasId id;

    @Column(name = "url", length = 30)
    private String url;

    @Column(name = "limite_pontos")
    private Integer limitePontos;

    @ManyToMany(mappedBy = "crachas", cascade = CascadeType.REMOVE)
    private Set<Jogadores> jogadores;


    public CrachasId getId() {
        return id;
    }

    public void setId(CrachasId id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLimitePontos() {
        return limitePontos;
    }

    public void setLimitePontos(Integer limitePontos) {
        this.limitePontos = limitePontos;
    }

}