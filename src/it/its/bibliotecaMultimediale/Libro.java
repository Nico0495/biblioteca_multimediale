package it.its.bibliotecaMultimediale;

import java.io.Serializable;
import java.io.Serial;
import java.util.Objects;

public class Libro extends MaterialeBiblioteca implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;  //da aggiungere sempre
    private final String ISBN;
    private final int pagine;
    private final Autore riferimentoAutore;

    public Libro(long id, String titolo, int annoDiRilascio, int disponibilita, String ISBM, int pagine, Autore riferimentoAutore) {
        super(id, titolo, annoDiRilascio, disponibilita);
        this.ISBN = ISBM;
        this.pagine = pagine;
        this.riferimentoAutore = riferimentoAutore;
    }

    public String getISBM() {
        return ISBN;
    }

    public int getPagine() {
        return pagine;
    }

    public Autore getRiferimentoAutore() {
        return riferimentoAutore;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;

        return ISBN.equals(libro.ISBN) && pagine == libro.pagine && riferimentoAutore.equals(libro.riferimentoAutore);
    }

    @Override
    public int hashCode() {
        int result = ISBN.hashCode();
        result = 31 * result + pagine;
        result = 31 * result + riferimentoAutore.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "\nid= " + this.getId() +
                ",\ntitolo= " + this.getTitolo() +
                ",\nannoDiRilascio= " + this.getAnnoDiRilascio() +
                ",\ndisponibilita = " + this.getDisponibilita() +
                ",\nISBM= " + ISBN +
                ",\npagine= " + pagine  +
                ",\nriferimentoAutore= " + riferimentoAutore +
                '}';
    }
}
