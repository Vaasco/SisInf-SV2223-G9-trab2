package orm.interfaces;

public interface IEstatisticasJogo {
    Character getIdGame();
    Integer getTotalPontosGame();
    Integer getNmrPlayers();
    Integer getNmrPartidasGame();

    void setIdGame(Character id);
    void setTotalPontosGame(Integer totalPontosGame);
    void setNmrPlayers(Integer nmrPlayers);
    void setNmrPartidasGame(Integer nmrPartidasGame);
}
