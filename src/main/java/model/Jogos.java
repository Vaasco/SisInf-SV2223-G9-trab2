package model;

import jakarta.persistence.*;
import orm.interfaces.IJogos;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jogos")
public class Jogos implements IJogos {
    @Id
    @Column(name = "id_game", length = 30, unique = true, nullable = false)
    private String id_game;

    @Column(name = "nome_game", length = 30, unique = true, nullable = false)
    private String nome_game;

    @Column(name = "url", length = 30)
    private String url;

    @OneToMany(mappedBy = "jogos", cascade = CascadeType.PERSIST)
    private List<EstatisticasJogo> estatisticas_jogos;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "comprar",
            joinColumns = @JoinColumn(name = "id_game"),
            inverseJoinColumns = @JoinColumn(name = "id_player")
    )
    private Set<Jogadores> jogadores;

    public String getId() {
        return id_game;
    }

    public void setId(String id) {
        this.id_game = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome_game() {
        return nome_game;
    }

    public void setNome_game(String nomeGame) {
        this.nome_game = nomeGame;
    }
}