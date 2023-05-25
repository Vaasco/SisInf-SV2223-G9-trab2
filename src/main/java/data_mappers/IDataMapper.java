package data_mappers;

public interface IDataMapper<T, Tid> {
    void Create(T entity);
    T Read(Tid id);
    void Update(T entity);
    void Delete(T entity);
}
