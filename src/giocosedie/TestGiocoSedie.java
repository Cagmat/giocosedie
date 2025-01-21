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
    String nomeFile= "file.txt";
    
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
	
    }
}
