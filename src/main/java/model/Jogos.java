package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogos {

    @Id
    @Column(name = "id_game")
    private Character idGame;

    @Column(name = "nome_game")
    private String nomeGame;

    @Column( name = "url" )
    private String url;

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
}
