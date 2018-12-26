package com.wipro.topgear.hibernate.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<E, ID extends Serializable> {
    E save(E entity);
    void delete(ID id);
    E update(E entity);
    E findById(ID id);
    List<E> findAll();
}
