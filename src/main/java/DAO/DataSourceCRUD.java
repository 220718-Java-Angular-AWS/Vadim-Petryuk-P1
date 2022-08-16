package DAO;
import java.util.List;
public interface DataSourceCRUD<T> {
    //CURD -CREATE READ UPDATE DELETE
    void create(T t);
    T read(int id);
    List<T> readAll();
    void update(T t);
    void delete(int id);
}