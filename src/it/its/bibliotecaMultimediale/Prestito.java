package it.its.bibliotecaMultimediale;

import java.time.LocalDate;

public class Prestito {
    private final MaterialeBiblioteca riferimentoMateriale;
    private final Utente riferimentoUtente;
    private final LocalDate dataPrestito;
    private final LocalDate dataRestituzione;

    public Prestito(MaterialeBiblioteca riferimentoMateriale, Utente riferimentoUtente, LocalDate dataPrestito, LocalDate dataRestituzione) {
        this.riferimentoMateriale = riferimentoMateriale;
        this.riferimentoUtente = riferimentoUtente;
        this.dataPrestito = dataPrestito;
        this.dataRestituzione = dataRestituzione;
    }

    public MaterialeBiblioteca getRiferimentoMateriale() {
        return riferimentoMateriale;
    }

    public Utente getRiferimentoUtente() {
        return riferimentoUtente;
    }

    public LocalDate getDataPrestito() {
        return dataPrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Prestito prestito)) return false;

        return riferimentoMateriale.equals(prestito.riferimentoMateriale) && riferimentoUtente.equals(prestito.riferimentoUtente) && dataPrestito.equals(prestito.dataPrestito) && dataRestituzione.equals(prestito.dataRestituzione);
    }

    @Override
    public int hashCode() {
        int result = riferimentoMateriale.hashCode();
        result = 31 * result + riferimentoUtente.hashCode();
        result = 31 * result + dataPrestito.hashCode();
        result = 31 * result + dataRestituzione.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "riferimentoMateriale=" + riferimentoMateriale +
                ", riferimentoUtente=" + riferimentoUtente +
                ", dataPrestito=" + dataPrestito +
                ", dataRestituzione=" + dataRestituzione +
                '}';
    }
}
