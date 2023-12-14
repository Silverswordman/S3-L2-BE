package giuliasilvestrini.dao;


import giuliasilvestrini.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location
    ) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location salvata correttamente: " + location);

    }
}
