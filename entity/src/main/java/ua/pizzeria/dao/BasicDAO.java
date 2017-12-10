package ua.pizzeria.dao;

import java.util.List;

public interface BasicDAO<T> {

    List<T> getAll();

    void add(T entity);

    void update(T entity);

    T getById(Integer id);

    void delete(T entity);

    void save(T entity);

    void merge(T entity);
}
