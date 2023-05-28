package model;

import jakarta.persistence.*;
import orm.interfaces.IJogadores;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "jogadores")
public class Jogadores implements IJogadores {
    @Id
    @Column(name = "id_player" , length = 40 , unique = true , nullable = false)
    private int id_player;

    @Column(name = "email", length = 40, unique = true, nullable = false)
    private String email;

    @Column(name = "username", length = 40, unique = true, nullable = false)
    private String username;

    @Column(name = "estado_player", length = 30)
    private String estadoPlayer;

    //Não tenho a certeza se é assim que se faz o mapeamento das associações!
    @ManyToOne
    @JoinColumn(name = "nome_regiao")
    private Regiao regiao;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.PERSIST)
    private List<EstatisticasJogadores> estatisticas_jogadores;

    @ManyToMany(mappedBy = "jogadores", cascade = CascadeType.PERSIST)
    private Set<Jogos> jogo;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "tem",
            joinColumns = @JoinColumn(name = "id_player"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Crachas> crachas;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "participar",
            joinColumns = @JoinColumn(name = "id_player"),
            inverseJoinColumns = @JoinColumn(name = "id_conversa"))
    private Set<Conversa> conversas;


    public int getId() {
        return id_player;
    }

    public void setId(int id) {
        this.id_player = id;
    }

    public String getEmail(){ return email;}

    public void setEmail(String email){ this.email = email;}

    public String getUsername(){ return username;}

    public void setUsername(String username){ this.username = username;}

    public String getEstadoPlayer() {
        return estadoPlayer;
    }

    public void setEstadoPlayer(String estadoPlayer) {
        this.estadoPlayer = estadoPlayer;
    }

    public Regiao getNomeRegiao(){return regiao;}

    public void setRegiao(Regiao regiao){this.regiao = regiao;}
}