package it.its.bibliotecaMultimediale;

public class Libro extends MaterialeBiblioteca {
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
                ", id=" + this.getId() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", annoDiRilascio=" + this.getAnnoDiRilascio() + '\'' +
                ", disponibilita=" + this.getDisponibilita() + '\'' +
                ", ISBM='" + ISBN + '\'' +
                ", pagine='" + pagine + '\'' +
                ", riferimentoAutore=" + riferimentoAutore +
                '}';
    }
}
