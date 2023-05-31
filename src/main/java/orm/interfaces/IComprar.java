package orm.interfaces;

import model.ComprarId;

import java.time.LocalDate;
public interface IComprar {
    ComprarId getId();
    LocalDate getDataCompra();
    Float getPreco();

    void SetId(ComprarId id);
    void setDataCompra(LocalDate dataCompra);
    void setPreco(Integer preco);


}
