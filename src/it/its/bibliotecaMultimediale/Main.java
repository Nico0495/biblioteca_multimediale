package it.its.bibliotecaMultimediale;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Main.caricaBiblioteca();
        GestioneNoleggi gestioneNoleggi = new GestioneNoleggi();
        GestioneUtenti gestioneUtenti = new GestioneUtenti();
        int scelta = 0;
        do {
            System.out.println("""
                    Benvenuto nel menù. Seleziona: \s
                    0- Esci
                    1- Per aggiungere materiale\s
                    2- Per aggiungere un utente\s
                    3- Per ricercare un materiale\s
                    4- Per richiedere un prestito\s
                    5- Per restituire un prestito\s
                    6- Per ricercare un utente""");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    Main.aggiungiMateriale(biblioteca, scanner);
                    break;
                case 2:
                    Main.aggiungiUtente(gestioneUtenti, scanner);
                    break;
                case 3:
                    Main.ricercaMateriale(biblioteca, scanner);
                    break;
                case 4:
                    Main.ricercaUtente(gestioneUtenti, scanner);
                    break;
                case 5:
                    Main.restituzioneNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                case 6:
                    Main.richiediNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
        Main.salvaBiblioteca(biblioteca);

    }

    private static void salvaBiblioteca(Biblioteca biblioteca) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\biblioteca.txt"))) {
            for (MaterialeBiblioteca materiale : biblioteca.getCollezioneMateriale()) {
                outputStream.writeObject(materiale);
            }
        } catch (IOException ex) {
            System.out.println("Errore in scrittura");
        }
    }


private static Biblioteca caricaBiblioteca() {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\biblioteca.txt"))) {
        Biblioteca biblioteca = new Biblioteca();
        MaterialeBiblioteca materialeBiblioteca = null;
        while ((materialeBiblioteca = (MaterialeBiblioteca) inputStream.readObject()) != null) {
            biblioteca.aggiungiMateriale(materialeBiblioteca);
        }
        return biblioteca;
    } catch (EOFException eofException) {
        System.out.println("End of file raggiunta");
    } catch (IOException | ClassNotFoundException ioEx){
        System.out.println("Eccezione");
    } finally {
        System.out.println("Questo lo eseguo sempre");
    }
    return new Biblioteca();

}


private static void richiediNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
}

private static void restituzioneNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
}

private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
}

private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner) {
    String titolo = scanner.nextLine();
    try {
        List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(titolo);
        System.out.println(("Risultato: " + risultato));
    } catch (Exception e) {
        System.out.println("Non ho trovato nessun elemento: " + titolo);
    }

}

private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
}

private static void aggiungiMateriale(Biblioteca biblioteca, Scanner scanner) {
    System.out.println("""
            Cosa vuoi aggiungere?
            1. Libro\s
            2. DVD\s
            3. Rivista\s
            """);
    int scelta = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Inserisci id: ");
    long id = scanner.nextLong();
    scanner.nextLine();
    System.out.println("Inserisci il titolo: ");
    String titolo = scanner.nextLine();
    System.out.println("Inserisci l'anno di rilascio: ");
    int annoDiRilascio = scanner.nextInt();
    System.out.println("Inserisci la disponibilità: ");
    int disponibilita = scanner.nextInt();
    scanner.nextLine();
    switch (scelta) {
        case 1:
            System.out.println("Hai selezionato: Libro!");
            System.out.println("Inserisci ISBN");
            String ISBN = scanner.nextLine();
            System.out.println("Inserisci il numero di pagine");
            int pagine = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci l'autore: ");
            Autore autore = Main.acquisisciAutore(scanner);
            Libro libro = new Libro(id, titolo, annoDiRilascio, disponibilita, ISBN, pagine, autore);
            biblioteca.aggiungiMateriale(libro);
            System.out.println("Libro è stato aggiunto");
            break;
        case 2:
            System.out.println("Hai selezionato: DVD!");
            System.out.println("Inserisci il regista: ");
            Autore regista = Main.acquisisciAutore(scanner);
            System.out.println("Inserisci la durata in minuti: ");
            int durata = scanner.nextInt();
            System.out.println("Inserisci il genere: ");
            String genere = scanner.nextLine();
            DVD.Genere genereEnum = DVD.Genere.lookUp(genere);
            DVD dvd = new DVD(id, titolo, annoDiRilascio, disponibilita, regista, durata, genereEnum);
            biblioteca.aggiungiMateriale(dvd);
            break;

        case 3:
            System.out.println("Hai selezionato: Rivista!");
            System.out.println("Uscita numero: ");
            int numeroUscita = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Periodicità: ");
            String periodicita = scanner.nextLine();
            Rivista.Periodicita periodicitaEnum = Rivista.Periodicita.lookup(periodicita);
            Rivista rivista = new Rivista(id, titolo, annoDiRilascio, disponibilita, numeroUscita, periodicitaEnum);
            biblioteca.aggiungiMateriale(rivista);
            System.out.println("Rivista aggiunta");
            break;
        default:
            System.out.println("Scelta non valida");
            break;


    }

}

private static Autore acquisisciAutore(Scanner scanner) {
    System.out.println("Inserisci il nome dell'autore: ");
    String nome = scanner.nextLine();
    System.out.println("Inserisci il cognome dell'autore: ");
    String cognome = scanner.nextLine();
    System.out.println("Inserisci la data di nascista nel formato gg/mm/aaaa: ");
    String dataNascita = scanner.nextLine();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
        LocalDate dataFormattataItalia = LocalDate.parse(dataNascita, format);
        Autore autore = new Autore(nome, cognome, dataFormattataItalia);
        return autore;

    } catch (DateTimeException ex) {
        System.out.println("Formato data errato!");
        return new Autore(nome, cognome, null);
    }

}


}


