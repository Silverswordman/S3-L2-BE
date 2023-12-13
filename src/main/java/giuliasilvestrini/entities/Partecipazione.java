package giuliasilvestrini.entities;


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

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statopartecipazione;

    public Partecipazione(long id, Persona persona, StatoPartecipazione statopartecipazione) {
        this.id = id;
        this.persona = persona;
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
