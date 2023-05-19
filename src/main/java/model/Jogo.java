package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogo {
    @EmbeddedId
    private JogoId id;

    @Column(name = "url", length = 30)
    private String url;

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