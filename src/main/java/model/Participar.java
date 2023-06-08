package model;

import jakarta.persistence.*;


@Entity
@Table(name = "participar")
public class Participar {

    @EmbeddedId
    private ParticiparId id;

    @ManyToOne
    @MapsId("idPlayer")
    @JoinColumn(name = "id_player")
    private Jogadores jogador;

    @ManyToOne
    @MapsId("idConversa")
    @JoinColumn(name = "id_conversa")
    private Conversas conversa;

    @Override
    public String toString() {
        return "Participar[" +
                "id_player = " + id.getIdPlayer() +
                " , nome_regiao = " + id.getNomeRegiao() +
                " , id_conversa = " + id.getIdConversa() +
                "]";
    }
}