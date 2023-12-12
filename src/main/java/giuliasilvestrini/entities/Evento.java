package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eventi") // non obbligatorio ricorda
public class Evento {

    @Id
    @GeneratedValue  // vuoi far gestire gli di dal database
    private long id;  // long per avere bigserial nel tipo del database

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private String dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventoType tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    //GETTERS
    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public EventoType getTipoEvento() {
        return tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }
}
