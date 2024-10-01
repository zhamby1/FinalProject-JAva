package org.fp.com;
import entities.*;


import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface CommonQueries<T>  {
    List<T> findAll();
    T findById(int id);



    void save(Person entity);

    void deleteById(int id);
}
