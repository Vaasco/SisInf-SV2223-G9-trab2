package data_access;

import data_mappers.IComprarMapper;
import model.Comprar;
import model.ComprarId;

public class Mappers {

    private final JPA_unit_of_work context;

    public Mappers(JPA_unit_of_work context) {
        this.context = context;
    }

    protected class ComprarMapper implements IComprarMapper {

        @Override
        public void Create(Comprar entity) {
            //context
        }

        @Override
        public Comprar Read(ComprarId id) {
            return null;
        }

        @Override
        public void Update(Comprar entity) {

        }

        @Override
        public void Delete(Comprar entity) {

        }
    }
}
