package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;

public class Utente implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    private final int id;
    private final String nome;
    private final String cognome;

    public Utente(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Utente utente)) return false;

        return id == utente.id && nome.equals(utente.nome) && cognome.equals(utente.cognome);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nome.hashCode();
        result = 31 * result + cognome.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Utente{" +
                ",\nID= " + id +
                ",\nNOME='" + nome +
                ",\nCOGNOME='" + cognome +
                '}';
    }
}
