package org.javabasics.csv.utenti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Utenti {

    private int id;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String indirizzo;
    private String documento;

    public Utenti() {
    }

    public Utenti(
            int id,
            String nome,
            String cognome,
            String dataDiNascita,
            String indirizzo,
            String documento) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.documento = documento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public static Map<Integer, Utenti> caricaUtenti() {
        String nomeFile = "C:\\Users\\LGNVCN01B\\OneDrive - DEDAGROUP SPA\\Desktop\\Nuova cartella\\src\\main\\java\\org\\javabasics\\csv\\utenti\\utenti.csv";
        Map<Integer, Utenti> map = new HashMap<>();
        try {
            Scanner inputStream = new Scanner(new File(nomeFile));
            String riga = inputStream.nextLine();

            while (inputStream.hasNextLine()) {
                Utenti utente = new Utenti();
                riga = inputStream.nextLine();
                String[] array = riga.split(";");
                utente.setId(Integer.parseInt(array[0]));
                utente.setNome(array[1]);
                utente.setDataDiNascita(array[2]);
                utente.setIndirizzo(array[3]);
                utente.setDocumento(array[4]);

                map.put(utente.getId(), utente);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile trovare il file " + nomeFile);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file " + nomeFile);
        }
        System.out.println("utenti.csv è stato caricato correttamente!");

        return map;
    }

    public String preparaStringaDaCaricare() {
        return (Integer.toString(this.id) + ";" + this.nome + ";" + this.cognome + ";" + this.dataDiNascita + ";"
                + this.indirizzo + ";" + this.documento);
    }

    public static void scriviCSVUtenti(Map<Integer, Utenti> map) {
        String nomeFile = "C:\\Users\\LGNVCN01B\\.vscode\\esercizi\\Java SE\\Progetto JAVA di Vincent Legnani\\project\\src\\csv\\utenti\\utenti.csv";
        try {
            FileWriter fileWriter = new FileWriter(nomeFile);
            fileWriter.append("ID;Nome;Cognome;Data di nascita;Indirizzo;Documento ID\n");
            Set<Integer> setOfMap = map.keySet();
            Object[] controller = setOfMap.toArray();
            for (int i = 0; i < controller.length; i++) {
                if (i == controller.length - 1) {
                    fileWriter.append(map.get(controller[i]).preparaStringaDaCaricare());
                    System.out.println(map.get(controller[i]).preparaStringaDaCaricare());
                } else if (i != controller.length - 1) {
                    fileWriter.append(map.get(controller[i]).preparaStringaDaCaricare() + "\n");
                }

            }
            System.out.println("Scrittura di Utenti avvenuta con successo!");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file" + nomeFile);
        } catch (IOException e) {
            System.out.println("Errore nella scrittura nel file" + nomeFile);
        }
    }
}
