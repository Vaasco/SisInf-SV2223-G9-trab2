package model;

import jakarta.persistence.*;

@Entity
@Table(name = "crachas")
public class Cracha {
    @EmbeddedId
    private CrachaId id;

    @Column(name = "url", length = 30)
    private String url;

    @Column(name = "limite_pontos")
    private Integer limitePontos;

    @ManyToMany( cascade=CascadeType.REMOVE )
        @JoinTable(name = "tem",
                joinColumns = @JoinColumn( "nome_cracha" ),
                inverseJoinColumns = @JoinColumn( name = )
        )

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