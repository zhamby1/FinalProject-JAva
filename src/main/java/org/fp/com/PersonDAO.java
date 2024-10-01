package org.fp.com;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonDAO implements CommonQueries {
    private EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void save(Person entity) {
        if (entity.getId() == 0) {
            entityManager.persist(entity);
        }
        else {
            entityManager.merge(entity);
        }

    }


    @Override
    public void deleteById(int id) {
        Person person = findById(id);
        if(person != null) {
            entityManager.remove(person);
        }


    }
}
