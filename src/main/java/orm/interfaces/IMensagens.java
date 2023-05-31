package orm.interfaces;

import model.Conversas;
import model.MensagensId;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IMensagens {
    MensagensId getId();

    String getTexto();
    String getRegiaoRemetente();

    Integer getRemetente();
    LocalTime getDataHoraMsg();

    void setId(MensagensId id);

    void setTexto(String texto);
    void setRegiaoRemetente(String regiaoRemetente);

    void setRemetente(Integer remente);
    void setDataHoraMsg(LocalTime dataHoraMsg);

}
