package operations;

import java.util.List;

public interface CrudOperations<T> {

    void save(T type);

    void deleteById(long id);

    void update(long id, T type);

    T findById(long id);

    List<T> findAll();
}
