package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "eventi")
public class Evento {

    @Id
    @GeneratedValue
    private long id;  // long per avere bigserial nel tipo del database

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventoType tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, EventoType tipoEvento, int numeroMassimoPartecipanti) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;

    }


    //GETTERS e SETTERS
    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = LocalDate.parse(dataEvento);
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(EventoType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }

    public Location getLocation() {
        return location;
    }
}
