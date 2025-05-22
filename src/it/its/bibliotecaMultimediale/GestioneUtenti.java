package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestioneUtenti {
    private final Set<Utente> collezioneUtenti;

    public GestioneUtenti() {
        this.collezioneUtenti = new HashSet<>();
    }
    public void aggiungiUtente(Utente nuovoUtente) {
        collezioneUtenti.add(nuovoUtente);
    }

    public String stampaCollezioneUtenti() {
        StringBuilder biulder = new StringBuilder();
        for (Utente utente : collezioneUtenti) {
            biulder.append(utente.toString()).append("\n");
        }
        return biulder.toString();
    }

    public void rimozioneUtente(long id) {
        for (Utente utente : collezioneUtenti) {
            if (utente.getId() == id) {
                collezioneUtenti.remove(utente);
                return;
            }
        }
    }

    public Utente ricercaUtente(long id) {
        for (Utente utente : collezioneUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

    public List<Utente> ricercaUtente(String nome, String cognome){
        List<Utente> risultato = new ArrayList<>();
        for(Utente utente : collezioneUtenti){
            if(utente.getNome().equals(nome) && utente.getCognome().equals(cognome)){
                risultato.add(utente);
            }
        }
        return risultato;
    }

    public List<Utente> ricercaUtente(String ricerca){
        List<Utente> risultato = new ArrayList<>();
        for(Utente utente : collezioneUtenti){
            if(utente.getNome().equals(ricerca) || utente.getCognome().equals(ricerca)){
                risultato.add(utente);
            }
        }
        return risultato;
    }

    public Set<Utente> getCollezioneUtenti() {
        return collezioneUtenti;
    }
}
