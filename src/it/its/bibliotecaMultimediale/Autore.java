package it.its.bibliotecaMultimediale;


import java.time.LocalDate;
import java.util.Objects;

public class Autore {
    private final String nome;
    private final String cognome;
    private final LocalDate dataNascita;

    public Autore(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    @Override
    public String toString() {
        return "Autore{" +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Autore autore)) return false;

        return nome.equals(autore.nome) && cognome.equals(autore.cognome) && dataNascita.equals(autore.dataNascita);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + cognome.hashCode();
        result = 31 * result + dataNascita.hashCode();
        return result;
    }
}
