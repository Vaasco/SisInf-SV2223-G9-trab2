package model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tem")
public class Tem {
    @EmbeddedId
    private TemId id;
}
