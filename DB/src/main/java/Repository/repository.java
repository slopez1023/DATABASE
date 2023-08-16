package Repository;

import java.util.List;

public interface repository <T> {
    List<T> list();
    T byId(Long id);
    void save(T t);

    void delete (Long id);
}
