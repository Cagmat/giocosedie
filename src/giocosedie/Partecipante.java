/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie;


class Partecipante extends Thread

{
	Posto sedie[];
        TestGiocoSedie testGiocoSedie;

	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

                        testGiocoSedie= new TestGiocoSedie();
                        testGiocoSedie.scrivi("", false);

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
                                    String messaggio= "Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i;
                                    System.out.println(messaggio);
                                    testGiocoSedie.scrivi(messaggio, true);
                                    return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()
					+ ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
