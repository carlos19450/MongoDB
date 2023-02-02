package org.example.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();
    Optional<T> findOneById(int id);
    T save(T t);
    Optional<T> updateById(int id);
    Optional<T> deleteById(int id);
}
