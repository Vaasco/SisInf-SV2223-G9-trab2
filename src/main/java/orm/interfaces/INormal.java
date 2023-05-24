package orm.interfaces;

import model.Jogadores;
import model.Jogos;
import model.NormalId;
import model.Regiao;

import java.time.LocalDate;

public interface INormal {
    NormalId getId();
    Regiao getNomeRegiao();
    Jogos getJogos();
    String getEstadoPartida();
    LocalDate getDataHoraInicio();
    LocalDate getDataHoraFim();
    Integer getPontuacaoN();
    Jogadores getJogadores();
    Integer getGrauDificuldade();

    void setId(NormalId id);
    void setNomeRegiao(Regiao nomeRegiao);
    void setJogos(Jogos jogos);
    void setEstadoPartida(String estadoPartida);
    void setDataHoraInicio(LocalDate dataHoraInicio);
    void setDataHoraFim(LocalDate dataHoraFim);
    void setPontuacaoN(Integer pontuacaoN);
    void setJogadores(Jogadores jogadores);
    void setGrauDificuldade(Integer grauDificuldade);

}
