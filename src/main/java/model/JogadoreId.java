package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JogadoreId implements Serializable {
    private static final long serialVersionUID = -2661032899308904502L;
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogadoreId entity = (JogadoreId) o;
        return Objects.equals(this.idPlayer, entity.idPlayer) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.username, entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, email, username);
    }

}