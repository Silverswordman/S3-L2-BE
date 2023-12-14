package giuliasilvestrini.dao;

import giuliasilvestrini.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione p) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Persona salvata correttamente: " + p);
    }
}
