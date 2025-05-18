package it.its.bibliotecaMultimediale;

public class DVD extends MaterialeBiblioteca{
    private final Autore Regista;
    private final int durata;
    public enum Genere {
        AZIONE,
        HORROR,
        DRAMMATICO
    }
    private final Genere genere;

    public DVD(long id, String titolo, int annoDiRilascio, int disponibilita, Autore regista, int durata, Genere genere) {
        super(id, titolo, annoDiRilascio, disponibilita);
        Regista = regista;
        this.durata = durata;
        this.genere = genere;
    }

    public Autore getRegista() {
        return Regista;
    }

    public int getDurata() {
        return durata;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof DVD dvd)) return false;

        return durata == dvd.durata && Regista.equals(dvd.Regista) && genere == dvd.genere;
    }

    @Override
    public int hashCode() {
        int result = Regista.hashCode();
        result = 31 * result + durata;
        result = 31 * result + genere.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DVD{" +
                ", id=" + this.getId() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", annoDiRilascio=" + this.getAnnoDiRilascio() + '\'' +
                ", disponibilita=" + this.getDisponibilita() + '\'' +
                ", regista=" + Regista +
                ", durata=" + durata +
                ", genere=" + genere +
                '}';
    }
}
