package giuliasilvestrini.dao;

import giuliasilvestrini.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;//

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento  " + evento.getTitolo() + " salvato con successo");
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }
}
