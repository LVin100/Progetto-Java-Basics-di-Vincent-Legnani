package org.javabasics.csv.prodotti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Prodotti{
    private int id;
    private String nome;
    private String dataDiInserimento;
    private String prezzo;
    private String marca;
    private String disponibile;

   
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setDataDiInserimento(String dataDiInserimento) {
        this.dataDiInserimento = dataDiInserimento;
    }

    public String getDataDiInserimento() {
        return dataDiInserimento;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setDisponibile(String disponibile) {
        this.disponibile = disponibile;
    }

    public String getDisponibile() {
        return disponibile;
    }

    public void stampaTutto(){
        System.out.println(this.id +"|"+this.nome+"|"+this.dataDiInserimento+"|"+this.prezzo+"|"+this.marca+"|"+this.disponibile);

    }
   
  public static Map<Integer, Prodotti> caricaProdotti() {
     String nomeFile = "C:\\Users\\LGNVCN01B\\OneDrive - DEDAGROUP SPA\\Desktop\\Nuova cartella\\src\\main\\java\\org\\javabasics\\csv\\prodotti\\prodotti.csv";
     Map<Integer, Prodotti> map = new HashMap<>();
    try {
      Scanner inputStream = new Scanner(new File(nomeFile));
      String riga = inputStream.nextLine();
     

      while (inputStream.hasNextLine()) {
        Prodotti prodotto = new Prodotti();
        riga = inputStream.nextLine();
        String[] array = riga.split(";");
        prodotto.setId(Integer.parseInt(array[0]));
        prodotto.setNome(array[1]);
        prodotto.setDataDiInserimento(array[2]);
        String[] str=array[3].split(" ");
        prodotto.setPrezzo(str[0]);
        prodotto.setMarca(array[4]);
        prodotto.setDisponibile(array[5]);

        map.put(prodotto.getId(), prodotto);
        

      }
    } catch (FileNotFoundException e) {
      System.out.println("Impossibile trovare il file " + nomeFile);
    } catch (IOException e) {
      System.out.println("Errore nella lettura del file " + nomeFile);
    }
    System.out.println("prodotti.csv è stato caricato correttamente!");

    return map;
  }

  public String preparaStringaDaCaricare(){
    return (Integer.toString(this.id) +";"+this.nome+";"+this.dataDiInserimento+";"+this.prezzo+";"+this.marca+";"+this.disponibile);
}

  public static void scriviCSVProdotti(Map<Integer, Prodotti> map, String nomeFile){
    //"C:\\Users\\LGNVCN01B\\.vscode\\esercizi\\Java SE\\Progetto JAVA di Vincent Legnani\\project\\src\\csv\\prodotti\\prodotti.csv";
        try{
            FileWriter outputStream = new FileWriter(nomeFile);
            outputStream.append("ID;Nome;Data di inserimento;Prezzo;Marca;Disponibile\n");
            Set<Integer> setOfMap = map.keySet();
            Object[] controller = setOfMap.toArray();
            for(int i = 0; i<controller.length; i++){
                if(i == controller.length-1){
                outputStream.append(map.get(controller[i]).preparaStringaDaCaricare());
                }else if (i != controller.length-1){
                    outputStream.append(map.get(controller[i]).preparaStringaDaCaricare()+"\n");
                }
            }
            System.out.println("Scrittura di prodotti avvenuta con successo!");
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Errore nell'apertura del file"+ nomeFile);
        }catch(IOException e) {
            System.out.println( "errore nella scrittura nel file"+ nomeFile) ;
        }
  }

}