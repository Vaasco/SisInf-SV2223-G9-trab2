package model;

import jakarta.persistence.*;
import orm.interfaces.ICrachas;

import java.util.List;

@Entity
@Table(name = "crachas")
public class Crachas implements ICrachas {

    @EmbeddedId
    private CrachasId id;

    @Column(name = "url")
    private String url;

    @Column(name = "limite_pontos")
    private Integer limitePontos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_game", insertable = false, updatable = false)
    private Jogos jogo;

    @OneToMany(mappedBy = "crachas")
    private List<Tem> tem;


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
