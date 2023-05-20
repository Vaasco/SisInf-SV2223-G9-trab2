package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jogadores")
public class Jogadore {
    @EmbeddedId
    private JogadoreId id;

    @Column(name = "estado_player", length = 30)
    private String estadoPlayer;

    //Não tenho a certeza se é assim que se faz o mapeamento das associações!
    @ManyToOne
    @JoinColumn(name = "nome_regiao")
    private Regiao regiao;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.PERSIST)
    private List<EstatisticasJogadore> estatisticas_jogadores;

    @ManyToMany(mappedBy = "jogadores",cascade=CascadeType.REMOVE )
    private Set<Jogo> jogos;



    public JogadoreId getId() {
        return id;
    }

    public void setId(JogadoreId id) {
        this.id = id;
    }

    public String getEstadoPlayer() {
        return estadoPlayer;
    }

    public void setEstadoPlayer(String estadoPlayer) {
        this.estadoPlayer = estadoPlayer;
    }

}