package org.javabasics.csv.vendite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vendite {
    int id;
    int idProdotto;
    int idUtente;

    public Vendite(){};

    public Vendite(int id, int idProdotto, int idUtente){
      this.id=id;
      this.idProdotto=idProdotto;
      this.idUtente=idUtente;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }
    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String preparaStringaDaCaricare(){
      return (Integer.toString(this.id) +";"+Integer.toString(this.idProdotto)+";"+Integer.toString(this.idUtente));
  }

    public static Map<Integer, Vendite> caricaVendite() {
        String nomeFile = "C:\\Users\\LGNVCN01B\\OneDrive - DEDAGROUP SPA\\Desktop\\Nuova cartella\\src\\main\\java\\org\\javabasics\\csv\\vendite\\vendite.csv";
        Map<Integer, Vendite> map = new HashMap<>();
       try {
         Scanner inputStream = new Scanner(new File(nomeFile));
         String riga = inputStream.nextLine();
 
   
         while (inputStream.hasNextLine()) {
           Vendite vendita = new Vendite();
           riga = inputStream.nextLine();
           String[] array = riga.split(";");
           vendita.setId(Integer.parseInt(array[0]));
           vendita.setIdProdotto(Integer.parseInt(array[1]));
           vendita.setIdUtente(Integer.parseInt(array[2]));
           
          
           map.put(vendita.getId(), vendita);
           
   
         }
       } catch (FileNotFoundException e) {
         System.out.println("Impossibile trovare il file " + nomeFile);
       } catch (IOException e) {
         System.out.println("Errore nella lettura del file " + nomeFile);
       }
       System.out.println("vendite.csv è stato caricato correttamente!");
   
       return map;
     }

     public static void scriviCSVVendite(Map<Integer, Vendite> map){
      String nomeFile="C:\\Users\\LGNVCN01B\\.vscode\\esercizi\\Java SE\\Progetto JAVA di Vincent Legnani\\project\\src\\csv\\vendite\\vendite.csv";
      try{
          FileWriter outputStream = new FileWriter(nomeFile);
          outputStream.append("ID;ID prodotto;ID utente\n");
          Set<Integer> setOfMap = map.keySet();
            Object[] controller = setOfMap.toArray();
            for(int i = 0; i<controller.length; i++){
                if(i == controller.length-1){
                outputStream.append(map.get(controller[i]).preparaStringaDaCaricare());
                }else if (i != controller.length-1){
                    outputStream.append(map.get(controller[i]).preparaStringaDaCaricare()+"\n");
                }
            }
          System.out.println("Scrittura di Vendite avvenuta con successo!");
          outputStream.close();
      }catch(FileNotFoundException e){
          System.out.println("Errore nell'apertura del file"+ nomeFile);
      }catch(IOException e) {
          System.out.println( "Errore nella scrittura nel file"+ nomeFile) ;
      }
}
}
