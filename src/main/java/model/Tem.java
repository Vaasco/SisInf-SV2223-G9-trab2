package model;

import jakarta.persistence.*;


@Entity
@Table(name = "tem")
public class Tem {
    @EmbeddedId
    private TemId id;

    @ManyToOne
    @MapsId("idPlayer")
    @JoinColumn(name = "id_player")
    private Jogadores jogador;

    @ManyToOne
    @MapsId("nomeCracha")
    @JoinColumns({
            @JoinColumn(name = "id_game", referencedColumnName = "id_game", insertable = false, updatable = false),
            @JoinColumn(name = "nome_cracha", referencedColumnName = "nome_cracha", insertable = false, updatable = false)
    })

    private Crachas crachas;

    public TemId getId() {
        return id;
    }

    public void setId(TemId id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Tem[" +
                "id_player = " + id.getIdPlayer() +
                " , nome_cracha = " + id.getNomeCracha() +
                " , id_game = " + id.getIdGame() +
                " , nome_regiao = " + id.getNomeRegiao() +
                "]";
    }
}
