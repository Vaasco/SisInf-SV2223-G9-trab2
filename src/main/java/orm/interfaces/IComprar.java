package orm.interfaces;

import model.ComprarId;

import java.sql.Timestamp;
import java.time.LocalDate;

public interface IComprar {
    ComprarId getId();
    LocalDate getDataCompra();
    Integer getPreco();

    void setId(ComprarId id);
    void setDataCompra(LocalDate dataCompra);
    void setPreco(Integer preco);


}
