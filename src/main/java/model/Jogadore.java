package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogadores")
public class Jogadore {
    @EmbeddedId
    private JogadoreId id;

    @Column(name = "estado_player", length = 30)
    private String estadoPlayer;

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