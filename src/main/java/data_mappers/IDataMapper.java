package data_mappers;


public interface IDataMapper<T, Tid> {
    Tid Create(T entity) throws Exception;

    T Read(Tid id) throws Exception;

    Tid Update(T entity) throws Exception;

    Tid Delete(T entity);
}