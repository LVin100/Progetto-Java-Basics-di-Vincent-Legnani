package org.javabasics.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.javabasics.Models.Prodotti;
import org.javabasics.Models.Utenti;
import org.javabasics.Models.Vendite;



public class FileManager {

    private Map<Integer, Utenti> utenti;
    private Map<Integer, Prodotti> prodotti;
    private Map<Integer, Vendite> vendite;

    public FileManager() {
        utenti = new HashMap<>();
        prodotti = new HashMap<>();
        vendite = new HashMap<>();
    }

    // import of "utenti.csv", "prodotti.csv", "vendite.csv"

    public void importFiles() {

        try {

            // reading "utenti.csv"
            InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("utenti.csv");
            if (ioStream == null) {
                throw new IllegalArgumentException("utenti.csv" + " is not found");
            }
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(ioStream));

            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");

                // creates a new user from data and saves it in a map
                Utenti utente = new Utenti(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
                utenti.put(Integer.parseInt(data[0]), utente);
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

        try {

            // reading "prodotti.csv"
            InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("prodotti.csv");
            if (ioStream == null) {
                throw new IllegalArgumentException("prodotti.csv" + " is not found");
            }
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(ioStream));

            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");

                // creates a new product from data and saves it in a map
                Prodotti prodotto = new Prodotti(Integer.parseInt(data[0]), data[1], data[2], data[3],data[4],data[5]);
                prodotti.put(Integer.parseInt(data[0]), prodotto);
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {

            // reading "vendite.csv"
            InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("vendite.csv");
            if (ioStream == null) {
                throw new IllegalArgumentException("vendite.csv" + " is not found");
            }
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(ioStream));

            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");

                // creates a new sale from data and saves it in a map
                Vendite vendita = new Vendite(Integer.parseInt(data[0]), Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                vendite.put(Integer.parseInt(data[0]), vendita);
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // getters
    public Collection<Utenti> getUsersCollection() {
        return this.utenti.values();
    }

    public Collection<Prodotti> getProductsCollection() {
        return this.prodotti.values();
    }

    public Collection<Vendite> getSalesCollection() {
        return this.vendite.values();
    }

    public boolean containsUser(Integer u) {

        if (utenti.containsKey(u)) {
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, Utenti> getUtenti(){
        return this.utenti;
    }
    public Map<Integer, Prodotti> getProdotti(){
        return this.prodotti;
    }
    public Map<Integer, Vendite> getVendite(){
        return this.vendite;
    }
}