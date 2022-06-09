package org.javabasics.menu;

import java.util.Map;

import org.javabasics.Models.Prodotti;
import org.javabasics.Models.Utenti;
import org.javabasics.Models.Vendite;

public class RestituireUnProdotto {
    public static void restituisciProdotto(int idVendita, Map<Integer, Prodotti> prodotti, Map<Integer, Utenti> utenti,
            Map<Integer, Vendite> vendite) {
        if (vendite.containsKey(idVendita)) {
            int idProdotto = vendite.get(idVendita).getIdProdotto();
            prodotti.get(idProdotto).setDisponibile("SI");
            Prodotti.scriviCSVProdotti(prodotti,
                    "prodotti.csv");

            vendite.remove(idVendita);
            vendite.values().remove(null);
            Vendite.scriviCSVVendite(vendite);

            System.out.println("Operazione conclusa con successo!");
        } else {
            System.out.println("L'ID inserito non corrisponde a nessun acquisto effettuato!");
        }
    }
}