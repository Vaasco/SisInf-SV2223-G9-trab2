package model;

import jakarta.persistence.*;

@Entity
@Table(name = "amigo")
public class Amigo {

    @EmbeddedId
    private AmigoId id;

    /*@ManyToOne
    private Jogadores jogadorOrigem;

    @ManyToOne
    private Jogadores jogadorDestino;*/

}
