package model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Comprar")
public class Comprar {
    @EmbeddedId
    private ComprarId id;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "preco")
    private Float preco;

    @ManyToOne
    @MapsId("idPlayer")
    @JoinColumn(name = "id_player")
    private Jogadores jogador;

    @ManyToOne
    @MapsId("idGame")
    @JoinColumn(name = "id_game")
    private Jogos jogo;

    public ComprarId getId() {
        return id;
    }

    public void setId(ComprarId id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Comprar[" + "id_game=" + id.getIdGame() + " ,id_player=" + id.getIdPlayer() + " ,nome_regiao=" + id.getNomeRegiao() + " ,data_compra=" + getDataCompra() + " ,preco=" + getPreco() + "]";
    }
}