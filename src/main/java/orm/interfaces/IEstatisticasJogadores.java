package orm.interfaces;

public interface IEstatisticasJogadores {
    Integer getNmrPartidasPlayer();
    Integer getNmrJogos();
    Integer getTotalPontosPlayer();

    void setNmrPartidasPlayer(Integer nmrPartidasPlayer);
    void setNmrJogos(Integer nmrJogos);
    void setTotalPontosPlayer(Integer totalPontosPlayer);
}
