package orm.interfaces;

public interface IJogos {
    String getId();
    String getUrl();
    String getNome_game();

    void setId(String id);
    void setUrl(String url);
    void setNome_game(String nomeGame);
}
