package model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "participar")
public class Participar {
    @EmbeddedId
    private ParticiparId id;
}
