package model;

import jakarta.persistence.*;

import java.util.Set;


//acho que falta o nome_cracha!!!
@Entity
@Table(name = "crachas")
public class Cracha {
    @EmbeddedId
    private CrachaId id;

    @Column(name = "url", length = 30)
    private String url;

    @Column(name = "limite_pontos")
    private Integer limitePontos;

    @ManyToMany(mappedBy = "crachas", cascade = CascadeType.REMOVE)
    private Set<Jogadore> jogadores;


    public CrachaId getId() {
        return id;
    }

    public void setId(CrachaId id) {
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