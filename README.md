Benvenut* nel mio progetto Java Basics!

Troverai un applicazione che simula un e-commerce Plant Based, ma passiamo subito al dunque, ora ti dico come farlo funzionare sul tuo pc. 

Comincia scaricando la cartella ed estraendola in locale, poi aprila con il tuo compilatore (ad esempio VS code). 

Apri il terminale (puoi farlo anche dal PROMPT COMANDI) e controlla di aver installato maven sul tuo computer digitando "mvn -version",
se questo passaggio dovesse dare errore significa che: o non hai istallato maven (e puoi farlo qui: https://maven.apache.org/download.cgi) oppure devi metterlo
tra le variabili di ambiente (cerca in pannello di controllo "modifica variabili di ambiente"-> Nuova -> Nome: MAVEN_HOME; Valore: <<qui inserisci il percorso 
alla cartella contenente maven, es. ...\apache-maven-3.8.5-bin\apache-maven-3.8.5->OK->doppio click su Path ->Nuovo->%MAVEN_HOME%\bin->OK. 
Bene! Adesso hai installato correttamente Maven e sei pront* ad utilizzare la mia applicazione!
  
Per sicurezza effettua nuovamente dal terminale (dopo averlo riavviato) la verifica della versione "mvn -version", se tutto è andato bene, dovresti vedere quale versione
di maven hai installato. 
  
Ma ora, passiamo all'utilizzo dell'e-commerce in java!
  
  apri l'intera cartella sul tuo compilatore, apri il terminale e scrivi "mvn compile package"
Se tutto va bene (come dovrebbe essere 😉) non riceverai errori e verrà creata una cartella chiamata "target" al cui interno c'è un file chiamato: "java-app-maven-package-1.0.0.jar"

  ultimo passaggio per avviare l'applicazione è il seguente:
  sempre da terminale scrivi java -jar target/java-app-maven-package-1.0.0.jar
  dopo aver compilato potrai, finalmente, utilizzare il mio progetto. 
  
  Ecco cosa troverai: 
  
  Ti verrà chiesto di selezionare un numero da 0 a 5, ogni numero effettuerà una funzione diversa: 
  0 ti farà chiudere l'applicazione;
  1 ti farà visualizzare tutti i prodotti all'interno del sistema, sia quelli disponibili che quelli non;
  2 ti farà comprare un prodotto tra quelli disponibili,
  3 ti farà effettuare il reso di un prodotto acquistato (puoi trovare l'elenco degli acquisti effettuati aprendo il file Vendite in src/main/java/org/javabasics/csv/vendite/vendite.csv.
  4 ti farà aggiungere un nuovo utente;
  5 ti esporterà un file .csv con riportati gli elementi disponibili (e quindi acquistabili)
  
  Bene, adesso sai tutto quello che c'è da sapere per utilizzare l'applicazione. Buon Divertimento!
