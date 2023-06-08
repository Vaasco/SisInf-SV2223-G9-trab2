package model;

import jakarta.persistence.*;

@Entity
@Table(name = "amigo")
public class Amigo {

    @EmbeddedId
    private AmigoId id;

    @ManyToOne
    @MapsId("idPlayer1")
    @JoinColumn(name = "id_player1")
    private Jogadores idPlayer1;

    @ManyToOne
    @MapsId("idPlayer2")
    @JoinColumn(name = "id_player2")
    private Jogadores idPlayer2;

}
