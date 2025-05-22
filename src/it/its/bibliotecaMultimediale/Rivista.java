package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Rivista extends MaterialeBiblioteca implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;   // da aggiungere sempre
    private final int numeroUscita;
    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE,
        ANNUALE;
        public static Map<String, Periodicita> PERIODICITA_MAP = new HashMap<>();

        static{
            PERIODICITA_MAP.put("settimanale", SETTIMANALE);
            PERIODICITA_MAP.put("mensile", MENSILE);
            PERIODICITA_MAP.put("SEMESTRALE", SEMESTRALE);
            PERIODICITA_MAP.put("annuale", ANNUALE);
        }

        public static Periodicita lookup (String value){
            if(value==null)
                throw new IllegalArgumentException("Valore nullo");
            value = value.toLowerCase();
            Periodicita periodicita = PERIODICITA_MAP.get(value);
            if(periodicita != null) {
                return periodicita;
            }else {
                throw new IllegalArgumentException("Genere non valido!");
            }
        }
    }

    private final Periodicita periodicita;

    public Rivista(long id, String titolo, int annoDiRilascio, int disponibilita, int numeroUscita, Periodicita periodicita) {
        super(id, titolo, annoDiRilascio, disponibilita);
        this.numeroUscita = numeroUscita;
        this.periodicita = periodicita;
    }

    public int getNumeroUscita() {
        return numeroUscita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                ", id=" + this.getId() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", annoDiRilascio=" + this.getAnnoDiRilascio() + '\'' +
                ", disponibilita=" + this.getDisponibilita() + '\'' +
                ", numeroUscite" + numeroUscita + '\'' +
                ", periodicita" + periodicita + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Rivista rivista)) return false;
        if (!super.equals(o)) return false;

        return numeroUscita == rivista.numeroUscita && periodicita == rivista.periodicita;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numeroUscita;
        result = 31 * result + periodicita.hashCode();
        return result;
    }
}
