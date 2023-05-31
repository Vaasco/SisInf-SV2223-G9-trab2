package orm.interfaces;

public interface IJogos {
    Character getIdGame();
    String getUrl();
    String getNomeGame();

    void setIdGame(Character id);
    void setUrl(String url);
    void setNomeGame(String nomeGame);
}
