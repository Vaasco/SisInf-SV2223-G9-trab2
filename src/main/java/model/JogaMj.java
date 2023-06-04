package model;

import jakarta.persistence.*;



@Entity
@Table(name = "joga_mj")
public class JogaMj  {
    @EmbeddedId
    private JogaMjId id;

    @Column(name = "pontuacao_mj")
    private Integer pontuacaoMj;

    @ManyToOne
    @MapsId("idPlayer")
    @JoinColumn(name = "id_player")
    private Jogadores jogador;

    @ManyToOne
    @MapsId("nmrSeqPartida")
    @JoinColumns({
            @JoinColumn(name = "nome_regiao", referencedColumnName = "nome_regiao", insertable = false , updatable = false),
            @JoinColumn(name = "id_game", referencedColumnName = "id_game", insertable = false, updatable = false),
            @JoinColumn(name = "nmr_seq_partida", referencedColumnName = "nmr_seq_partida", insertable = false, updatable = false)
    })
    private Multijogador multijogador;


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

    @Override
    public String toString(){
        return "JogaMj[" +
                "nmr_seq-partida = "    + id.getNmrSeqPartida() +
                " , id_game = "         + id.getIdGame() +
                " , nome_regiao = "     + id.getNomeRegiao() +
                " , id_player = "       + id.getIdPlayer() +
                " , pontuacao_mj = "    + getPontuacaoMj() +
                "]";
    }
}