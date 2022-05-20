package org.javabasics.menu;

import java.util.Map;

import org.javabasics.csv.prodotti.Prodotti;
import org.javabasics.csv.utenti.Utenti;
import org.javabasics.csv.vendite.Vendite;

public class CompraProdotto {
    public static void compraProdotto(int idProdotto, int idUtente, Map<Integer, Prodotti> prodotti, Map<Integer, Utenti> utenti, Map<Integer, Vendite> vendite ){
     
        if(prodotti.get(idProdotto).getDisponibile().equals("SI")){
            System.out.println("entrato nell'if SI");
        prodotti.get(idProdotto).setDisponibile("NO");
        System.out.println("settata disponibilità a NO");
            int idVendita=1;
        while (vendite.containsKey(idVendita)){
        idVendita++;
        }
        System.out.println("setto l'id nuovo tramite la formula");
        Vendite vendita = new Vendite(idVendita,idProdotto,idUtente);
        System.out.println("creata nuova vendita di idVendita="+idVendita+" idProdotto="+idProdotto+" e idUtente"+idUtente);
        vendite.put(idVendita, vendita);
        System.out.println("inserita la nuova vendita nell'array, adesso il programma avvia la scrittura dei file CSV");
        Prodotti.scriviCSVProdotti(prodotti, "C:\\Users\\LGNVCN01B\\.vscode\\esercizi\\Java SE\\Progetto JAVA di Vincent Legnani\\project\\src\\csv\\prodotti\\prodotti.csv");
        Vendite.scriviCSVVendite(vendite);


        }else{
            System.out.println(prodotti.get(idProdotto).getDisponibile());
            System.out.println("Il prodotto non è disponibile!");
        }
    

    }
}
