package model;


import jakarta.persistence.*;
import org.eclipse.persistence.jpa.config.Cascade;
import orm.interfaces.IJogadores;

import java.util.List;


@Entity
@Table(name = "jogadores")


public class Jogadores{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player", length = 40, unique = true, nullable = false)
    private Integer id_player;

    @Column(name = "email", length = 40,unique = true,nullable = false)
    private String email;

    @Column(name = "username", length = 40, unique = true, nullable = false)
    private String username;

    @Column(name = "estado_player", length = 30)
    private String estadoPlayer;

    @Column(name = "nome_regiao")
    private String nomeRegiao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nome_regiao", insertable = false, updatable = false)
    private Regiao regiao;

    @OneToMany(mappedBy = "jogador")
    private List<Normal> jogadoresNormais;

    @OneToMany(mappedBy = "jogador")
    private List<estatisticas_jogadores> estatisticasJogadores;

    @OneToMany(mappedBy = "jogador")
    private List<Tem> tem;

    /*@OneToMany
    private List<Jogadores> amigos;*/

    @OneToMany(mappedBy = "jogador")
    private List<Comprar> comprar;

    @OneToMany(mappedBy = "jogador")
    private List<Participar> participar;

    @OneToMany(mappedBy = "jogador")
    private List<JogaMj> jogaMj;


    public int getId() {
        return id_player;
    }

    public void setId(int id) {
        this.id_player = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEstadoPlayer() {
        return estadoPlayer;
    }

    public void setEstadoPlayer(String estadoPlayer) {
        this.estadoPlayer = estadoPlayer;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    @Override
    public String toString() {
        return "Jogadores[" +
                "id_player = " + id_player +
                " , email = " + getEmail() +
                " , username = " + getUsername() +
                " , estado_player = " + getEstadoPlayer() +
                " , nome_regiao = " + getNomeRegiao() +
                "]";
    }
}
