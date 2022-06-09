package org.javabasics;

import org.javabasics.Controllers.FileManager;
import org.javabasics.menu.Menu;

public class Main {

  public static void main(String[] args) {
    // Map<Integer, Prodotti> prodotti = Prodotti.caricaProdotti();
    // Map<Integer, Utenti> utenti = Utenti.caricaUtenti();
    // Map<Integer, Vendite> vendite = Vendite.caricaVendite();

      FileManager importer = new FileManager();
      importer.importFiles();
    Menu.menu(importer.getProdotti(), importer.getUtenti(), importer.getVendite());
  }
}
