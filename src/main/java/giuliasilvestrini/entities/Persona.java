package giuliasilvestrini.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_nascita;

    @Enumerated(EnumType.STRING)
    private sesso sessochoice;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    // 1 to Many diventa così BIDIREZIONALE (NON E' OBBLIGATORIO)
    // Non verrà creata nessuna colonna aggiuntiva a DB
    // La bidirezionalità mi servirà solo LATO JAVA per poter accedere
    // da un utente alla lista dei blog che ha scritto
    private List<Partecipazione> partecipazioneList;

    public Persona(long id, String nome, String cognome, String email, LocalDate data_nascita, sesso sessochoice, List<Partecipazione> partecipazioneList) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.sessochoice = sessochoice;
        this.partecipazioneList = partecipazioneList;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public sesso getSessochoice() {
        return sessochoice;
    }

    public void setSessochoice(sesso sessochoice) {
        this.sessochoice = sessochoice;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    public void setPartecipazioneList(List<Partecipazione> partecipazioneList) {
        this.partecipazioneList = partecipazioneList;
    }
}
