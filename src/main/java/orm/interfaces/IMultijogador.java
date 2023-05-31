package orm.interfaces;

import model.Jogadores;
import model.Jogos;
import model.MultijogadorId;
import model.Regiao;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IMultijogador {
    /*MultijogadorId getId();

    Integer getIdPlayer();

    Regiao getNomeRegiaoMultijogador();


    String getEstadoPartida();

    LocalTime getDataHoraInicio();

    LocalTime getDataHoraFim();

    Integer getJogadores();

    void setId(MultijogadorId id);

    void setNomeRegiaoMultijogador(Regiao nomeRegiao);


    void setEstadoPartida(String estadoPartida);

    void setDataHoraInicio(LocalTime dataHoraInicio);

    void setDataHoraFim(LocalTime dataHoraFim);

    void setJogadores(Jogadores jogadores);

    void setIdPlayer(Integer idPlayer);*/

    String getNomeRegiao();

    Character getIdGame();

    Integer nmrSeqPartida();

    String getEstadoPartida();

    LocalTime getDataHoraInicio();

    LocalTime getDataHoraFim();

    Integer idPlayer();


    void setNomeRegiao(String nomeRegiao);

    void setIdGame(Character idGame);

    void setNmrSeqPartida(Integer nmrSeqPartida);

    void setEstadoPartida(String estadoPartida);

    void setDataHoraInicio(LocalTime dataHoraInicio);

    void setDataHoraFim(LocalTime dataHoraFim);

    void setIdPlayer(Integer idPlayer);

}
