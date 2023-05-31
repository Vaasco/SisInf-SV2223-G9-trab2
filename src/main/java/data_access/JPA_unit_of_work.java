package data_access;

import jakarta.persistence.*;
import unit_of_work.IUnitOfWork;


// TODO: 25/05/2023 Adicionar tratamento de erros
public class JPA_unit_of_work /*implements IUnitOfWork*/ {

    private EntityManagerFactory _emf;

    protected EntityManager _em;

    protected EntityTransaction _tx;

    private final String persistenceUnitName = "JPAEx";

    public JPA_unit_of_work() {
        _emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        _em = _emf.createEntityManager();
    }

    //@Override
    public void beginTransaction() {
        if (_tx == null || !_tx.isActive()) {
            _tx = _em.getTransaction();
            _tx.begin();
        }
    }
/*
    @Override
    public void commit() {
        if (_tx != null && _tx.isActive()) {
            _tx.commit();
        }
    }

    @Override
    public void rollback() {
        if (_tx != null && _tx.isActive()) {
            _tx.rollback();
        }
    }

    @Override
    public void flush() {
        if (_em != null) {
            _em.flush();
        }
    }

    @Override
    public void connect() {
        try {
            if (_emf != null && !_emf.isOpen()) _emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            if (_em != null && !_em.isOpen()) _em = _emf.createEntityManager();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }*/

    public void close(){
        if(_em != null && _em.isOpen()) _em.close();
        if(_emf != null && _emf.isOpen()) _emf.close();
    }





    //Alínea 2d
    public void criar_jogador(String email, String username, String nome_regiao) {
        EntityTransaction transaction = _em.getTransaction();
        transaction.begin();
        try {
            Query query = _em.createNativeQuery("CALL criar_jogador(?, ?, ?)");
            query.setParameter(1, email);
            query.setParameter(2, username);
            query.setParameter(3, nome_regiao);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            throw e;
        }

    }


    public static void main(String[] args) {

        JPA_unit_of_work Test = new JPA_unit_of_work();
        String email = "yoo@gmail.com";
        String username = "yooUser";
        String nome_regiao = "Asia";
        Test.criar_jogador(email, username, nome_regiao);
        Test.close();
    }
}

