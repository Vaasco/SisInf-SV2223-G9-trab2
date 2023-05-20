package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jogos")
public class Jogo {
    @EmbeddedId
    private JogoId id;

    @Column(name = "url", length = 30)
    private String url;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.PERSIST)
    private List<EstatisticasJogo> estatisticas_jogos;

    public JogoId getId() {
        return id;
    }

    public void setId(JogoId id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}