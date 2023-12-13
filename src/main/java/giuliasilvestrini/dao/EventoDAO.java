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
        System.out.println("Evento  " + evento.getId() + " " + evento.getTitolo() + " salvato con successo");
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Evento found = em.find(Evento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
