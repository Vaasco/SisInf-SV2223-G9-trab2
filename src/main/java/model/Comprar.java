package model;

import jakarta.persistence.*;
import orm.interfaces.IComprar;

import java.time.LocalDate;

@Entity
@Table(name = "comprar")
public class Comprar implements IComprar {
    @EmbeddedId
    private ComprarId id;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "preco")
    private Integer preco;


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


    public Integer getPreco() {
        return preco;
    }



    public void setPreco(Integer preco) {
        this.preco = preco;
    }

}