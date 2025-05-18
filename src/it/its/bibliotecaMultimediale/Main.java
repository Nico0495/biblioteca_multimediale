package it.its.bibliotecaMultimediale;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

                                            // REGISTI DVD
        Autore spielberg = new Autore("Steven", "Spielberg", LocalDate.of(1946, 12, 18));
        Autore nolan = new Autore("Christopher", "Nolan", LocalDate.of(1970, 7, 30));
        Autore tarantino = new Autore("Quentin", "Tarantino", LocalDate.of(1963, 3, 27));
        Autore fellini = new Autore("Federico", "Fellini", LocalDate.of(1920, 1, 20));
        Autore leone = new Autore("Sergio", "Leone", LocalDate.of(1929, 1, 3));
        Autore sorrentino = new Autore("Paolo", "Sorrentino", LocalDate.of(1970, 5, 31));
        Autore cavani = new Autore("Liliana", "Cavani", LocalDate.of(1933, 1, 12));
        Autore comencini = new Autore("Cristina", "Comencini", LocalDate.of(1956, 5, 8));
        Autore dante = new Autore("Emma", "Dante", LocalDate.of(1967, 4, 6));
        Autore delToro = new Autore("Guillermo", "del Toro", LocalDate.of(1964, 10, 9));


                                            // AUTORI LIBRI
        Autore king = new Autore("Steven", "King", LocalDate.of(1947, 9, 21));
        Autore rowling = new Autore("J.K.", "Rowling", LocalDate.of(1965, 7, 31));
        Autore murakami = new Autore("Haruki", "Murakami", LocalDate.of(1974, 6, 22));
        Autore brown = new Autore("Dan", "Brown", LocalDate.of(1947, 9, 21));
        Autore martin = new Autore("George R.R.", "Martin", LocalDate.of(1948, 9, 20));
        Autore marquez = new Autore("Gabriel Garcìa", "Màrquez", LocalDate.of(1927, 3, 27));
        Autore orwell = new Autore("George", "Orwell", LocalDate.of(1903, 6, 25));
        Autore tolkien = new Autore("J.R.R.", "Tolkien", LocalDate.of(1892, 1, 3));
        Autore grisham = new Autore("John", "Grisham", LocalDate.of(1955, 2, 8));
        Autore smith = new Autore("Wilbur", "Smith", LocalDate.of(1933, 1, 9));


        //        DVD presenti nella biblioteca
        DVD salvateIlSoldatoRyan = new DVD(
                1L,
                "Salvate il soldato Ryan",
                1998,
                5,
                spielberg,
                169,
                DVD.Genere.AZIONE
        );

        DVD ilCavaliereOscuro = new DVD(
                2L,
                "Il cavaliere oscuro",
                2008,
                5,
                nolan,
                152,
                DVD.Genere.AZIONE
        );

        DVD theHatefulEight = new DVD(
                3L,
                "The Hateful Eight",
                2015,
                4,
                tarantino,
                168,
                DVD.Genere.DRAMMATICO
        );

        DVD laStrada = new DVD(
                4L,
                "La strada",
                1954,
                3,
                fellini,
                108,
                DVD.Genere.DRAMMATICO
        );

        DVD cEraUnaVoltaIlWest = new DVD(
                5L,
                "C'era una volta il West",
                1968,
                4,
                leone,
                165,
                DVD.Genere.AZIONE
        );

        DVD eStataLaManoDiDio = new DVD(
                6L,
                "È stata la mano di Dio",
                2021,
                3,
                sorrentino,
                130,
                DVD.Genere.DRAMMATICO
        );

        DVD ilPortiereDiNotte = new DVD(
                7L,
                "Il portiere di notte",
                1974,
                2,
                cavani,
                118,
                DVD.Genere.DRAMMATICO
        );

        DVD laBestiaNelCuore = new DVD(
                8L,
                "La bestia nel cuore",
                2005,
                2,
                comencini,
                120,
                DVD.Genere.DRAMMATICO
        );

        DVD leSorelleMacaluso = new DVD(
                9L,
                "Le sorelle Macaluso",
                2020,
                1,
                dante,
                94,
                DVD.Genere.DRAMMATICO
        );

        DVD crimsonPeak = new DVD(
                10L,
                "Crimson Peak",
                2015,
                4,
                delToro,
                119,
                DVD.Genere.HORROR
        );

//        Libri presenti nella biblioteca
        Libro it = new Libro(
                11L,
                "IT",
                1986,
                5,
                "978-0450411434",
                "1138",
                king
        );

        Libro harryPotterELaPietraFilosofale = new Libro(
                12L,
                "Harry Potter e la Pietra Filosofale",
                1997,
                4,
                "978-8831003384",
                "336",
                rowling
        );

        Libro norwegianWood = new Libro(
                13L,
                "Norwegian Wood",
                1987,
                4,
                "978-0375704024",
                "296",
                murakami
        );

        Libro ilCodiceDaVinci = new Libro(
                14L,
                "Il codice da Vinci",
                2003,
                5,
                "978-88-04-52341-3",
                "528",
                brown
        );

        Libro centAnniDiSolitudine = new Libro(
                15L,
                "Cent'anni di solitudine",
                1967,
                4,
                "978-8804573494",
                "404",
                marquez
        );

        Libro ilTronoDiSpade = new Libro(
                16L,
                "Il trono di spade",
                1996,
                5,
                "978-8804750550",
                "672",
                martin
        );

        Libro ilSignoreDegliAnelliTrilogia = new Libro(
                17L,
                "Il signore degli anelli (Trilogia)",
                1994,
                5,
                "978-8818123696",
                "1376",
                tolkien
        );

        Libro lAppello = new Libro(
                18L,
                "L'Appello",
                1994,
                4,
                "978-8804407225",
                "594",
                grisham
        );

        Libro ilDioDelFiume = new Libro(
                19L,
                "Il dio del fiume",
                1993,
                4,
                "978-8830411296",
                "610",
                smith
        );

        Libro ilGrandeFratello= new Libro(
                20L,
                "1984",
                1949,
                5,
                "978-8804798657",
                "336",
                orwell
        );

//        riviste presenti in biblioteca
        Rivista nationalGeographic = new Rivista(
                21L,
                "National Geographic",
                2024,
                5,
                780,
                Rivista.Periodicita.MENSILE
        );

        Rivista theEconomist = new Rivista(
                22L,
                "The Economist",
                2024,
                18,
                920,
                Rivista.Periodicita.SETTIMANALE
        );

        Rivista scientificAmerican = new Rivista(
                23L,
                "Scientific American",
                2024,
                2,
                144,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista panorama = new Rivista(
                24L,
                "Panorama",
                2024,
                21,
                72,
                Rivista.Periodicita.SETTIMANALE
        );

        Rivista focus = new Rivista(
                25L,
                "Focus",
                2024,
                10,
                359,
                Rivista.Periodicita.MENSILE
        );

        Rivista vogue = new Rivista(
                26L,
                "Vogue",
                2024,
                6,
                265,
                Rivista.Periodicita.MENSILE
        );

        Rivista archeo = new Rivista(
                27L,
                "Archeo",
                2024,
                1,
                110,
                Rivista.Periodicita.ANNUALE
        );

        Rivista colors = new Rivista(
                28L,
                "Colors",
                2024,
                1,
                130,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista mitTechnologyReview = new Rivista(
                29L,
                "MIT Technology Review",
                2024,
                2,
                188,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista slow = new Rivista(
                30L,
                "Slow",
                2024,
                1,
                98,
                Rivista.Periodicita.ANNUALE
        );


//        aggiunta dei DVD nella biblioteca
        biblioteca.aggiungiMateriale(salvateIlSoldatoRyan);
        biblioteca.aggiungiMateriale(ilCavaliereOscuro);
        biblioteca.aggiungiMateriale(theHatefulEight);
        biblioteca.aggiungiMateriale(laStrada);
        biblioteca.aggiungiMateriale(cEraUnaVoltaIlWest);
        biblioteca.aggiungiMateriale(eStataLaManoDiDio);
        biblioteca.aggiungiMateriale(ilPortiereDiNotte);
        biblioteca.aggiungiMateriale(laBestiaNelCuore);
        biblioteca.aggiungiMateriale(leSorelleMacaluso);
        biblioteca.aggiungiMateriale(crimsonPeak);

//        aggiunta dei libri nella biblioteca
        biblioteca.aggiungiMateriale(it);
        biblioteca.aggiungiMateriale(harryPotterELaPietraFilosofale);
        biblioteca.aggiungiMateriale(norwegianWood);
        biblioteca.aggiungiMateriale(ilCodiceDaVinci);
        biblioteca.aggiungiMateriale(centAnniDiSolitudine);
        biblioteca.aggiungiMateriale(ilTronoDiSpade);
        biblioteca.aggiungiMateriale(ilSignoreDegliAnelliTrilogia);
        biblioteca.aggiungiMateriale(lAppello);
        biblioteca.aggiungiMateriale(ilDioDelFiume);
        biblioteca.aggiungiMateriale(ilGrandeFratello);

//        aggiunta delle riviste nella biblioteca
        biblioteca.aggiungiMateriale(nationalGeographic);
        biblioteca.aggiungiMateriale(theEconomist);
        biblioteca.aggiungiMateriale(scientificAmerican);
        biblioteca.aggiungiMateriale(panorama);
        biblioteca.aggiungiMateriale(focus);
        biblioteca.aggiungiMateriale(vogue);
        biblioteca.aggiungiMateriale(archeo);
        biblioteca.aggiungiMateriale(colors);
        biblioteca.aggiungiMateriale(mitTechnologyReview);
        biblioteca.aggiungiMateriale(slow);

        System.out.println("Lista completa della biblioteca:");
        System.out.println(biblioteca.stampaCollezioneMateriale());
    }
}

