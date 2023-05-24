package orm.interfaces;

import model.Regiao;

public interface IJogadores {
    int getId();
    String getEmail();
    String getUsername();
    String getEstadoPlayer();
    Regiao getNomeRegiao();

    void setId(int id);
    void setEmail(String email);
    void setUsername(String username);
    void setEstadoPlayer(String estadoPlayer);
    void setRegiao(Regiao regiao);
}
