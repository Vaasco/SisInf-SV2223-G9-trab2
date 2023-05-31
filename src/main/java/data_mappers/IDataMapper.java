package data_mappers;

public interface IDataMapper<T, Tid> {
    Tid Create(T entity);
    T Read(Tid id);
    Tid Update(T entity);
    Tid Delete(T entity);
}
