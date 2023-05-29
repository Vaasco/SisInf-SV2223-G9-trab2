package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name = "Comprar")

public class Comprar {
    @EmbeddedId
    private ComprarId id;

    @Column(name = "data_compra")
    private LocalTime dataCompra;

    @Column(name = "preco")
    private Float preco;


    public LocalTime getDataCompra(){
        return dataCompra;
    }

    public void setDataCompra(LocalTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
