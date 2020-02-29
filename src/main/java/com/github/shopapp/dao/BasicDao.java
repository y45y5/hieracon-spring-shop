package com.github.shopapp.dao;

import java.util.List;

public interface BasicDao<T> {
    List<T> getFullList();

    void save(T t);
    void update(T t);
    void delete(T t);
}
