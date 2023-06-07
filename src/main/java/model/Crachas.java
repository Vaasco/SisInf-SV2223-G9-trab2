package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;


import java.util.List;

@Entity
@Table(name = "crachas")
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
public class Crachas {

    @EmbeddedId
    private CrachasId id;

    @Column(name = "url")
    private String url;


    @Version
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

    @Override
    public String toString() {
        return "Cracha[" +
                "id_game = " + id.getIdGame() +
                " , nome_cracha = " + id.getNomeCracha() +
                " , url = " + getUrl() +
                " ,limite_pontos=" + getLimitePontos() +
                "]";
    }



}
