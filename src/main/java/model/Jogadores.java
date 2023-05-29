package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogadores")


public class Jogadores{

    @Id
    @Column(name = "id_player", length = 40,unique = true,nullable = false)
    private Integer id_player;

    @Column(name = "email", length = 40,unique = true,nullable = false)
    private String email;

    @Column(name = "username", length = 40, unique = true, nullable = false)
    private String username;

    @Column(name = "estado_player", length = 30)
    private String estadoPlayer;

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

}
