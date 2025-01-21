package giocosedie;

import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestGiocoSedie {
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    String nomeFile= "Veschini_file.txt";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();

        // Determina il numero di sedie: sempre una in meno rispetto ai partecipanti
        int numSedie = numPartecipanti - 1;
        Posto[] sedie = new Posto[numSedie];

        // Inizializzazione delle sedie
        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.");
        display.start();

        Partecipante[] partecipanti = new Partecipante[numPartecipanti];

        for (int i = 0; i < numPartecipanti; i++) {
            partecipanti[i] = new Partecipante(sedie);
            logger.info("Sto facendo partire il thread id: " + partecipanti[i].getId() + " name: " + partecipanti[i].getName());
            partecipanti[i].start();
        }

        scanner.close();
	}

    public void scrivi(){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            //2) scrivo nel buffer
            br.write("File in output");
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            //Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
		System.err.println("Stampa l'ID");
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                //Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
			System.err.println("Stampa");
            }
                
        }
    }
    
    public void scrivi(String messaggio, boolean append){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile,append));
            //2) scrivo nel buffer
            br.write(messaggio);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            //Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
		System.err.println(ex.getMessage());
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                //Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
			System.err.println(ex.getMessage());
            }
                
        }
    }
}
