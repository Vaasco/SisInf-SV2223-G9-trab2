package model;

import jakarta.persistence.*;
import orm.interfaces.IJogos;

import java.util.List;


@Entity
@Table(name = "jogos")
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private Character idGame;

    @Column(name = "nome_game")
    private String nomeGame;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "jogo")
    private List<Crachas> crachas;

    @OneToMany(mappedBy = "jogo")
    private List<estatisticas_jogo> estatisticasJogos;

    @OneToMany(mappedBy = "jogo")
    private List<Comprar> comprar;

    @OneToMany(mappedBy = "jogoNormal", cascade = CascadeType.PERSIST)
    private List<Normal> normal;

    @OneToMany(mappedBy = "jogoMultijogador" , cascade = CascadeType.PERSIST)
    private List<Multijogador> multijogador;


    public Character getIdGame() {
        return idGame;
    }

    public void setIdGame(Character idGame) {
        this.idGame = idGame;
    }

    public String getNomeGame() {
        return nomeGame;
    }

    public void setNomeGame(String nomeGame) {
        this.nomeGame = nomeGame;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Jogos[" +
                "id_game = "        + getIdGame() +
                " , nome_game = "   + getNomeGame() +
                " , url = "         + getUrl() +
                "]";
    }
}
