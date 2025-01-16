package giocosedie;

class Partecipante extends Thread

{
	Posto sedie[];
        String messaggio;
	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
                                    messaggio += "Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i ;
                                    
					System.out.println(messaggio);
					return;
				}
			}
                        messaggio += "Sono il Thread " + this.getName()
					+ ". Ho perso :((((";
			System.out.println(messaggio);

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
                
               
            Scrittore s= new Scrittore("file", messaggio);
            s.scrivi();
        
        }
        
}
