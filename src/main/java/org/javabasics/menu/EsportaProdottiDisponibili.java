package org.javabasics.menu;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.javabasics.csv.prodotti.Prodotti;

public class EsportaProdottiDisponibili {

    public static void esportaProdottiDisponibili(Map<Integer, Prodotti> prodotti){
        
        Map<Integer, Prodotti> prodottiDisponibili = new HashMap<>();
        
        for(Integer key : prodotti.keySet()){
           
            if(prodotti.get(key).getDisponibile().equals("SI")){
               
                prodottiDisponibili.put(key, prodotti.get(key));
               
            }
        }
        
        scriviCSVProdottiDisponibili(prodottiDisponibili);
       
    }
    public static String stringaDaCaricare(Prodotti prodotto){
        return (Integer.toString(prodotto.getId())+";"+prodotto.getDataDiInserimento() +";"+prodotto.getNome()+";"+prodotto.getMarca()+";"+prodotto.getPrezzo());
    }
    public static void scriviCSVProdottiDisponibili(Map<Integer, Prodotti> map){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_uuuu");
        LocalDate localDate = LocalDate.now();
        String currentDate = dtf.format(localDate);
        String nomeFile="prodotti_"+currentDate+".csv";
        try{
            FileWriter outputStream = new FileWriter(nomeFile);
            outputStream.append("ID;Data di inserimento;Nome;Marca;Prezzo;\n");
            Set<Integer> setOfMap = map.keySet();
            Object[] controller = setOfMap.toArray();
            for(int i = 0; i<controller.length; i++){
                if(i == controller.length-1){
                outputStream.append(stringaDaCaricare(map.get(controller[i])));
                }else if (i != controller.length-1){
                    outputStream.append(stringaDaCaricare(map.get(controller[i]))+"\n");
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
