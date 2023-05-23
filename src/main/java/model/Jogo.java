package model;

import jakarta.persistence.*;
import org.eclipse.persistence.jpa.config.Cascade;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jogos")
public class Jogo {
    @EmbeddedId
    private JogoId id;

    @Column(name = "url", length = 30)
    private String url;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.PERSIST)
    private List<EstatisticasJogo> estatisticas_jogos;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "comprar",
            joinColumns = @JoinColumn(name = "id_game"),
            inverseJoinColumns = @JoinColumn(name = "id_player")
    )
    private Set<Jogadore> jogadores;

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