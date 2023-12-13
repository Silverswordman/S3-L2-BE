package giuliasilvestrini.entities;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String città;

    @OneToOne(mappedBy = "eventi")
    private Evento evento;


    public Location(long id, String nome, String città, Evento evento) {
        this.id = id;
        this.nome = nome;
        this.città = città;
        this.evento = evento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
