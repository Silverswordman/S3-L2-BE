package giuliasilvestrini.entities;


import giuliasilvestrini.dao.EventoDAO;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona; // <--- FOREIGN KEY

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento; // <--- FOREIGN KEY


    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statopartecipazione;

    public Partecipazione(long id, Persona persona, Evento evento, StatoPartecipazione statopartecipazione) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.statopartecipazione = statopartecipazione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public StatoPartecipazione getStatopartecipazione() {
        return statopartecipazione;
    }

    public void setStatopartecipazione(StatoPartecipazione statopartecipazione) {
        this.statopartecipazione = statopartecipazione;
    }
}
