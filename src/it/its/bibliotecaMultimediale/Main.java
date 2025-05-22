package it.its.bibliotecaMultimediale;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Main.caricaBiblioteca();
        GestioneUtenti gestioneUtenti = Main.caricaUtenti();
        GestioneNoleggi gestioneNoleggi = Main.caricaNoleggi();
        int scelta = 0;
        do {
            System.out.println("""
                    Benvenuto nel menù. Seleziona: \s
                    0- Esci
                    1- Per aggiungere materiale\s
                    2- Per aggiungere un utente\s
                    3- Per ricercare un materiale\s
                    4- Per ricercare un utente\s
                    5- Per restituire un noleggio\s
                    6- Per richiedere un noleggio\s
                    7- Per ricercare un prestito\s
                    8- Stampa i noleggi""");
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
                case 7:
                    Main.ricercaNoleggi(biblioteca, gestioneUtenti, gestioneNoleggi, scanner);
                    break;
                case 8:
                    System.out.println(gestioneNoleggi.getCollezioneNoleggi());
                    break;

                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
        Main.salvaBiblioteca(biblioteca);
        Main.salvaUtenti(gestioneUtenti);
        Main.salvaNoleggi(gestioneNoleggi);

    }

    private static void salvaBiblioteca(Biblioteca biblioteca) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\biblioteca.txt"))) {
            for (MaterialeBiblioteca materiale : biblioteca.getCollezioneMateriale()) {
                outputStream.writeObject(materiale);
            }
        } catch (IOException ex) {
            System.out.println("Errore in scrittura");
            ex.printStackTrace();
        }
    }


    private static Biblioteca caricaBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\biblioteca.txt"))) {
            MaterialeBiblioteca materialeBiblioteca = null;
            while ((materialeBiblioteca = (MaterialeBiblioteca) inputStream.readObject()) != null) {
                biblioteca.aggiungiMateriale(materialeBiblioteca);
            }
            return biblioteca;
        } catch (EOFException eofException) {
            System.out.println("Caricati: " + biblioteca.getCollezioneMateriale().size());
            System.out.println("Elementi: " + biblioteca.getCollezioneMateriale());
            System.out.println("End of file raggiunta");
        } catch (IOException | ClassNotFoundException ioEx) {
            System.out.println("Eccezione");
            ioEx.printStackTrace();
        } finally {
            System.out.println("Questo lo eseguo sempre");
        }
        return biblioteca;
    }

    public static GestioneUtenti caricaUtenti() {
        GestioneUtenti gestioneUtenti = new GestioneUtenti();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\utenti.txt"))) {
            Utente utente = null;
            while ((utente = (Utente) inputStream.readObject()) != null) {
                gestioneUtenti.aggiungiUtente(utente);
            }
            System.out.println("Caricati: " + gestioneUtenti.getCollezioneUtenti().size());
            return gestioneUtenti;
        } catch (EOFException e) {
            System.out.println("Caricamento dell'utente completato");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eccezione");
            e.printStackTrace();
        }
        return gestioneUtenti;
    }

    private static void salvaNoleggi(GestioneNoleggi gestioneNoleggi) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\noleggi.txt"))) {
            for (Noleggio noleggio : gestioneNoleggi.getCollezioneNoleggi()) {
                outputStream.writeObject(noleggio);
            }
        } catch (IOException ex) {
            System.out.println("Errore in scrittura");
            ex.printStackTrace();
        }
    }


    public static GestioneNoleggi caricaNoleggi(){
        GestioneNoleggi gestioneNoleggi = new GestioneNoleggi();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\noleggi.txt"))) {
        Noleggio noleggio = null;
        while ((noleggio = (Noleggio) inputStream.readObject()) != null) {
            gestioneNoleggi.aggiungiNoleggio(noleggio);
        }
        System.out.println("Caricati: " + gestioneNoleggi.stampaCollezioneNoleggi());
        return gestioneNoleggi;
    } catch (EOFException e) {
        System.out.println("Caricamento del noleggio completato");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Eccezione");
        e.printStackTrace();
    }
        return gestioneNoleggi;
}



    public static void salvaUtenti(GestioneUtenti gestioneUtenti) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\A867apulia\\IdeaProjects\\Biblioteca multimediale\\resource\\utenti.txt"))) {
            for (Utente utente : gestioneUtenti.getCollezioneUtenti()) {
                outputStream.writeObject(utente);
            }
        } catch (IOException ex) {
            System.out.println("Errore in scrittura");
            ex.printStackTrace();
        }
    }


    private static void richiediNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("Inserisci l'id del materiale: ");
        long id;
        id = scanner.nextLong();
        scanner.nextLine();
        MaterialeBiblioteca riferimentoMateriale = biblioteca.ricercaElementi(id);
        System.out.println("Inserisci l'id dell'utente: ");
        id = scanner.nextLong();
        scanner.nextLine();
        Utente riferimentoUtente = gestioneUtenti.ricercaUtente((long)id);
        LocalDate dataNoleggio = LocalDate.now();
        if (riferimentoUtente!= null && riferimentoMateriale.getDisponibilita() > 0) {
            riferimentoMateriale.setDisponibilita(riferimentoMateriale.getDisponibilita() - 1);
            Noleggio noleggio = new Noleggio(riferimentoMateriale, riferimentoUtente, dataNoleggio);
            gestioneNoleggi.aggiungiNoleggio(noleggio);
            System.out.println("Noleggio aggiunto!!");
        }

    }

    private static void restituzioneNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("Inserisci l'id del materiale: ");
        long id= scanner.nextLong();
        scanner.nextLine();
        MaterialeBiblioteca riferimentoMateriale = biblioteca.ricercaElementi(id);
        System.out.println("Inserisci l'id dell'utente: ");
        id = scanner.nextLong();
        scanner.nextLine();
        Utente riferimentoUtente = gestioneUtenti.ricercaUtente((int) id);
        System.out.println("Inserisci la data di inizio noleggio nel formato gg/mm/aaaa: ");
        String dataNoleggio = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormattataItalia = null;
        try {
            dataFormattataItalia = LocalDate.parse(dataNoleggio, format);
            if (riferimentoUtente != null && riferimentoMateriale != null) {
                gestioneNoleggi.restituzioneNoleggio(riferimentoUtente.getId(), riferimentoMateriale.getId(), dataFormattataItalia);
                riferimentoMateriale.setDisponibilita(riferimentoMateriale.getAnnoDiRilascio() + 1);
                System.out.println("Noleggio restituito");
            }

        } catch (DateTimeParseException ex) {
            System.out.println("Formato data errato! ");
        }

    }

    public static void ricercaNoleggi(Biblioteca biblioteca, GestioneUtenti gestioneUtenti, GestioneNoleggi gestioneNoleggi, Scanner scanner){
        System.out.println("""
                Scegli come ricercare il prestito. Spingi: \s" +
                "1- per ricercare per utente\s" +
                "2- per ricercare per materiale""");
        int scelta=scanner.nextInt();
        scanner.nextLine();
        switch (scelta){
            case 1:
                System.out.println("Inserisci l'id dell'utente: ");
                int idUtente= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci il nome dell'utente: ");
                String nome= scanner.nextLine();
                System.out.println("Inserisci il cognome dell'utente: ");
                String cognome= scanner.nextLine();
                Utente utente= new Utente(idUtente, nome, cognome);
                try{
                    List<Noleggio> risultatoNoleggio= gestioneNoleggi.ricercaNoleggi(utente);
                    System.out.println("Risultato: " +risultatoNoleggio);
                } catch (Exception e) {
                    System.out.println("non ho trovato nessun elemento con Utente: " + utente);

                }
                break;
            case 2:
                System.out.println("Inserisci l'id del materiale: ");
                long idMateriale=scanner.nextInt();
                scanner.nextLine();
                MaterialeBiblioteca materialeBiblioteca= biblioteca.ricercaElementi(idMateriale);
                try{
                    List<Noleggio> risultatoNoleggio= gestioneNoleggi.ricercaNoleggi(materialeBiblioteca);
                    System.out.println("Risultato: " +risultatoNoleggio);
                } catch (Exception e) {
                    System.out.println("non ho trovato nessun elemento con materiale: " + materialeBiblioteca);
                }
                break;
            case 3:
                System.out.println("Inserisci l'id dell'utente: ");
                idUtente= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci l'id del materiale: ");
                idMateriale=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci la data di inizio prestito nel formato gg/mm/aaaa ");
                String dataNoleggio = scanner.nextLine();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate dataFormattataItalia = LocalDate.parse(dataNoleggio, format);
                    Noleggio risultato= gestioneNoleggi.ricercaNoleggi(idUtente, idMateriale, dataFormattataItalia);
                    System.out.println("Risultato: " +risultato);
                } catch (DateTimeParseException ex) {
                    System.out.println("Formato data errato! ");
                }
                break;
            default:
                System.out.println("Errore");
        }
    }


    private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("Come vuoi cercare l'Utente? " +
                "\n1. Id " +
                "\n2. Nome e Cognome" +
                "\n3. Nome o Cognome");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta) {
            case 1:
                System.out.println("Inserisci l'Id: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                try {
                    Utente risultato = gestioneUtenti.ricercaUtente(id);
                    System.out.println(("Risultato: " + risultato));
                } catch (Exception e) {
                    System.out.println("Non ho trovato nessun elemento: " + id);
                }
                break;
            case 2:
                System.out.println("Inserisci il nome da ricercare: ");
                String nome = scanner.nextLine();
                System.out.println("Inserisci il cognome da ricercare: ");
                String cognome = scanner.nextLine();
                try {
                    List<Utente> risultato = gestioneUtenti.ricercaUtente(nome, cognome);
                    System.out.println("Risultato: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non ho trovato nessun elemento con nome: " + nome + "e cognome: " + cognome);
                }
                break;
            case 3:
                System.out.println("Inserisci il nome o cognome da ricercare: ");
                String ricerca = scanner.nextLine();
                try {
                    List<Utente> risultato = gestioneUtenti.ricercaUtente(ricerca);
                    System.out.println("Risultato: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non ho trovato nessun elemento con nome o cognome: " + ricerca);
                }
                break;
        }


    }

    private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Per cosa vuoi ricercare il materiale?" +
                "\n1. Titolo" +
                "\n2. Autore" +
                "\n3. Tipo");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta) {
            case 1:
                System.out.println("Inserisci il titolo: ");
                String titolo = scanner.nextLine();
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(titolo);
                    System.out.println(("Risultato: " + risultato));
                } catch (Exception e) {
                    System.out.println("Non ho trovato nessun elemento: " + titolo);
                }
                break;
            case 2:
                System.out.println("Inserisci il nome dell'autore e del regista: ");
                Autore autore = Main.acquisisciAutore(scanner);
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(autore);
                    System.out.println("Risultato: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non ho trovato nessun elemento Autore: " + autore);
                }
                break;
            case 3:
                Map<String, Class<? extends MaterialeBiblioteca>> TIPO_MAP = new HashMap<>();
                TIPO_MAP.put("libro", Libro.class);
                TIPO_MAP.put("DVD", DVD.class);
                TIPO_MAP.put("Rivista", Rivista.class);
                System.out.println("Inserisci il tipo da cercare: ");
                String tipo = scanner.nextLine();
                if (tipo == null)
                    throw new IllegalArgumentException("Valore nullo");
                tipo = tipo.toLowerCase();
                Class<? extends MaterialeBiblioteca> tipoClass = TIPO_MAP.get(tipo);
                if (tipoClass == null) {
                    throw new IllegalArgumentException("Tipo non valido!");
                }
                List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(tipoClass);
                System.out.println("Risultato della ricerca: " + risultato);
                break;
        }

    }

    private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("Inserisci id utente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome: ");
        String cognome = scanner.nextLine();
        Utente utente = (new Utente(id, nome, cognome));
        gestioneUtenti.aggiungiUtente(utente);
        System.out.println("Utente aggiunto correttamente! " + utente);

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
                scanner.nextLine();
                System.out.println("Inserisci il genere: ");
                String genere = scanner.nextLine();
                DVD.Genere genereEnum = DVD.Genere.lookUp(genere);
                DVD dvd = new DVD(id, titolo, annoDiRilascio, disponibilita, regista, durata, genereEnum);
                biblioteca.aggiungiMateriale(dvd);
                System.out.println("DVD è stato aggiunto");
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


