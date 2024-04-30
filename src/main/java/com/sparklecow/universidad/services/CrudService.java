package com.sparklecow.universidad.services;

import java.util.List;

public interface CrudService <T,X>{
    T save(X x);
    List<T> findAll();
    T findById(Integer id);
    T update(X x, Integer id);
    void delete(Integer id);
}
