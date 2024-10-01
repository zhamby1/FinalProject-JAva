package org.fp.com;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        PersonDAO dao = new PersonDAO(em);
        List<Person> personList = dao.findAll();
        System.out.println(personList);
    }
}
