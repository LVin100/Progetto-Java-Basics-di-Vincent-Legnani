package org.javabasics.menu;
import java.util.Map;
import java.util.Scanner;

import org.javabasics.csv.utenti.Utenti;

public class RegistraUnNuovoUtente {
    public static void registraNuovoUtente(Map<Integer, Utenti>utenti){
        String nome,cognome,dataDiNascita,indirizzo,documento;
        Scanner intScanner = new Scanner(System.in);
        System.out.println("Digitare l'ID del nuovo utente");
        int idUtente= intScanner.nextInt();
        intScanner.close();
        
        if(! utenti.containsKey(idUtente)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digitare il nome del nuovo utente");
             nome = scanner.nextLine();
             if(nome == ""){
                 System.out.println("Il nome non può essere nullo");
                 while(nome == ""){
                     nome = scanner.nextLine();
                 }
             }
            System.out.println("Digitare il cognome del nuovo utente");
             cognome= scanner.nextLine();
            System.out.println("Digitare la data di nascita del nuovo utente");
             dataDiNascita= scanner.nextLine();
            System.out.println("Digitare l'indirizzo del nuovo utente");
             indirizzo= scanner.nextLine();
            System.out.println("Digitare il codice della carta d'identità del nuovo utente");
             documento= scanner.nextLine();
             scanner.close();
        Utenti utente = new Utenti(idUtente, nome, cognome, dataDiNascita, indirizzo, documento);
        utenti.put(idUtente,utente);
            Utenti.scriviCSVUtenti(utenti);
        }else{
            System.out.println("Esiste già un utente con l'ID digitato!");
        }

    }
}
