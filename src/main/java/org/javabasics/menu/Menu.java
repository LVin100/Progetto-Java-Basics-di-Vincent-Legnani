package org.javabasics.menu;

import java.util.Map;
import java.util.Scanner;

import org.javabasics.Models.Prodotti;
import org.javabasics.Models.Utenti;
import org.javabasics.Models.Vendite;

public class Menu {

    public static void menu(Map<Integer, Prodotti> prodotti, Map<Integer, Utenti> utenti,
            Map<Integer, Vendite> vendite) {
        System.out.println("\nBenvenuto su Planty of Food! l'e-commerce plant-based");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean sentinel = false;
            while (sentinel == false) {
                System.out.println(
                        "\nDigita 1 per visualizzare tutti i prodotti; \nDigita 2 per comprare un prodotto; \nDigita 3 per effettuare un reso di un prodotto acquistato; \nDigita 4 per registrare un nuovo utente; \nDigita 5 per esportare il file con i prodotti disponibili; \nDigita 0 se vuoi uscire dal programma.\n");
                int opzione = scanner.nextInt();
                switch (opzione) {
                    case 1: {
                        MostraTuttiProdotti.mostraTuttiProdotti(prodotti);
                        break;
                    }
                    case 2: {
                        System.out.println("Digitare l'ID del prodotto");
                        int idProdotto = scanner.nextInt();
                        System.out.println("Digitare l'ID dell'utente");
                        int idUtente = scanner.nextInt();
                        CompraProdotto.compraProdotto(idProdotto, idUtente, prodotti, utenti, vendite);
                        break;
                    }
                    case 3: {
                        System.out.println("Digitare l'ID relativo all'acquisto effettuato");
                        int idVendita = scanner.nextInt();
                        RestituireUnProdotto.restituisciProdotto(idVendita, prodotti, utenti, vendite);
                        break;
                    }
                    case 4: {

                        RegistraUnNuovoUtente.registraNuovoUtente(utenti);
                        break;
                    }
                    case 5: {
                        EsportaProdottiDisponibili.esportaProdottiDisponibili(prodotti);
                        break;
                    }
                    case 0: {
                        System.out.println("Grazie per aver utilizzato il nostro servizio!");
                        sentinel = true;
                        break;
                    }
                    default: {
                        System.out.println("l'opzione digitata non è valida, prego, digitare un numero da 0 a 5.");

                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
