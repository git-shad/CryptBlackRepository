package tool;

interface database<T> {
    void insert(T data)throws java.sql.SQLException;
    void update(T data)throws java.sql.SQLException;
    java.util.Queue getAllData();
    void delete(int id);
}
