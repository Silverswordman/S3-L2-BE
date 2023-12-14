package giuliasilvestrini.dao;

import giuliasilvestrini.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona salvata correttamente: " + persona);
    }}
