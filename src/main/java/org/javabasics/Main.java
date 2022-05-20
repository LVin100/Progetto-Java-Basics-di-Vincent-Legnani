package org.javabasics;

import java.util.Map;
import org.javabasics.csv.prodotti.Prodotti;
import org.javabasics.csv.utenti.Utenti;
import org.javabasics.csv.vendite.Vendite;
import org.javabasics.menu.Menu;



public class Main {


  public static void main(String[] args) {
   Map <Integer,Prodotti> prodotti = Prodotti.caricaProdotti();
   Map <Integer, Utenti> utenti = Utenti.caricaUtenti();
   Map <Integer, Vendite> vendite =Vendite.caricaVendite();
    
  Menu.menu(prodotti, utenti, vendite);
  }
}
