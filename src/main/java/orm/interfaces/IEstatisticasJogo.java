package orm.interfaces;

public interface IEstatisticasJogo {
    Integer getId();
    Integer getTotalPontosGame();
    Integer getNmrPlayers();
    Integer getNmrPartidasGame();

    void setId(Integer id);
    void setTotalPontosGame(Integer totalPontosGame);
    void setNmrPlayers(Integer nmrPlayers);
    void setNmrPartidasGame(Integer nmrPartidasGame);
}
