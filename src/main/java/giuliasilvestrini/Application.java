package giuliasilvestrini;

import com.github.javafaker.Faker;
import giuliasilvestrini.dao.EventoDAO;
import giuliasilvestrini.dao.LocationDAO;
import giuliasilvestrini.entities.Evento;
import giuliasilvestrini.entities.EventoType;
import giuliasilvestrini.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();

        Faker faker = new Faker(Locale.ITALY);
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO LocationDAO = new LocationDAO(em);
        Random rndm = new Random();
        Faker faker2 = new Faker(Locale.ITALY);

        eventoDAO.save(new Evento(
                faker.chuckNorris().fact(),
                LocalDate.of(rndm.nextInt(2023, 2025),
                        rndm.nextInt(1, 13),
                        rndm.nextInt(1, 29)),
                faker.lorem().fixedString(50),
                rndm.nextInt(1, 3) == 1 ? EventoType.Privato : EventoType.Pubblico,
                rndm.nextInt(1, 200)));


        LocationDAO.save(new Location(faker2.address().city(), faker2.address().city()));


        Evento found = eventoDAO.findById(219);
        if (found != null)
            System.out.println(found);
        else System.out.println("Elemento non trovato");


        em.close();
        emf.close();
    }


}
