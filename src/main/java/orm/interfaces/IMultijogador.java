package orm.interfaces;

import model.Jogadores;
import model.Jogos;
import model.MultijogadorId;
import model.Regiao;

import java.time.LocalDate;

public interface IMultijogador {
    MultijogadorId getId();
    Regiao getNomeRegiao();
    Jogos getJogos();
    String getEstadoPartida();
    LocalDate getDataHoraInicio();
    LocalDate getDataHoraFim();
    Jogadores getJogadores();

    void setId(MultijogadorId id);
    void setNomeRegiao(Regiao nomeRegiao);
    void setJogos(Jogos jogos);
    void setEstadoPartida(String estadoPartida);
    void setDataHoraInicio(LocalDate dataHoraInicio);
    void setDataHoraFim(LocalDate dataHoraFim);
    void setJogadores(Jogadores jogadores);
}
