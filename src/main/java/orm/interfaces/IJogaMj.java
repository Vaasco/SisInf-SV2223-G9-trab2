package orm.interfaces;

import model.JogaMjId;

public interface IJogaMj {
    JogaMjId getId();
    Integer getPontuacaoMj();

    void setId(JogaMjId id);
    void setPontuacaoMj(Integer pontuacaoMj);
}
