package unit_of_work;

public interface IUnitOfWork {
    void beginTransaction();
    void commit();
    void rollback();
    void flush();
    void connect();

    void close();


}
