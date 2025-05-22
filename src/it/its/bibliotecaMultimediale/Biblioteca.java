package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {

    private final Set<MaterialeBiblioteca> collezioneMateriale;
    private final Set<Utente> collezioneUtente;
    private final Set<Prestito> collezionePrestito;

    public Biblioteca() {
        this.collezioneMateriale = new HashSet<>();
        this.collezioneUtente = new HashSet<>();
        this.collezionePrestito = new HashSet<>();
    }

    public void aggiungiMateriale(MaterialeBiblioteca materialeBiblioteca) {
        collezioneMateriale.add(materialeBiblioteca);
    }

    public void aggiungiUtente(Utente utente) {
        collezioneUtente.add(utente);
    }

    public void aggiungiPrestito(Prestito prestito) {
        collezionePrestito.add(prestito);
    }

    public String stampaCollezioneMateriale() {
        StringBuilder builder = new StringBuilder();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            builder.append(materialeBiblioteca.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public String stampaCollezioneUtente() {
        StringBuilder builder = new StringBuilder();
        for (Utente utente : collezioneUtente) {
            builder.append(utente.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public String stampaCollezionePrestito() {
        StringBuilder builder = new StringBuilder();
        for (Prestito prestito : collezionePrestito) {
            builder.append(prestito.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public List<MaterialeBiblioteca> ricercaElementi(String titolo) throws Exception {
        // modificato accesso, tipo ritorno, nome metodo e parametri
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (titolo.equals(materialeBiblioteca.getTitolo())) {
                risultato.add(materialeBiblioteca);
            }
        }
        if(risultato.isEmpty())
            throw new NoItemException("Errore");
        return risultato;
    }

    public List<MaterialeBiblioteca> ricercaElementi(Autore autore) {
        // modificato accesso, tipo ritorno, nome metodo e parametri
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (materialeBiblioteca instanceof Libro libro) {
                if (autore.equals(libro.getRiferimentoAutore())) {
                    risultato.add(materialeBiblioteca);
                }
            } else if (materialeBiblioteca instanceof DVD dvd) {
                if (autore.equals(dvd.getRegista())) {
                    risultato.add(materialeBiblioteca);
                }
            }
        }
        return risultato;

    }

    public MaterialeBiblioteca ricercaElementi(long id){
        for (MaterialeBiblioteca materiale : collezioneMateriale) {
            if (id==materiale.getId()) {
                return materiale;
            }
        }
        return null;
    }

    public List<MaterialeBiblioteca> ricercaElementi(Class<? extends MaterialeBiblioteca > clazz) {
        // modificato accesso, tipo ritorno, nome metodo e parametri
        List<MaterialeBiblioteca> ricercaTipo = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (materialeBiblioteca.getClass().equals(clazz)) {
                ricercaTipo.add(materialeBiblioteca);
            }
        }
        return ricercaTipo;
    }

    public Set<MaterialeBiblioteca>getCollezioneMateriale(){
        return this.collezioneMateriale;
    }

}
