package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "joga_mj")
public class JogaMj {
    @EmbeddedId
    private JogaMjId id;

    @Column(name = "pontuacao_mj")
    private Integer pontuacaoMj;

    public JogaMjId getId() {
        return id;
    }

    public void setId(JogaMjId id) {
        this.id = id;
    }

    public Integer getPontuacaoMj() {
        return pontuacaoMj;
    }

    public void setPontuacaoMj(Integer pontuacaoMj) {
        this.pontuacaoMj = pontuacaoMj;
    }

}