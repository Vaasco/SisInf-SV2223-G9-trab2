package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstatisticasJogadoreId implements Serializable {
    private static final long serialVersionUID = -4787335739005452531L;
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstatisticasJogadoreId entity = (EstatisticasJogadoreId) o;
        return Objects.equals(this.idPlayer, entity.idPlayer) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.username, entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, email, username);
    }

}