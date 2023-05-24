package orm.interfaces;

import model.Conversa;
import model.MensagensId;

import java.time.LocalDate;

public interface IMensagens {
    MensagensId getId();
    Conversa getIdConversa();
    String getTexto();
    String getRemetente();
    LocalDate getDataHoraMsg();

    void setId(MensagensId id);
    void setIdConversa(Conversa idConversa);
    void setTexto(String texto);
    void setRemetente(String remetente);
    void setDataHoraMsg(LocalDate dataHoraMsg);

}
