package no.hvl.dat100;

/*
 * Oppgave B5
 * a) Lag et program som leser inn en poengsum (heltall) som en student har oppnådd på en prøve, og finn og skriv ut den karakteren A-F dette tilsvarer. 
 *    Skriv ut feilmelding ved ugyldig poengsum (negativ verdi eller over 100).
 *    
 * b) Utvid programmet i pkt. a) slik at det kan lese inn poengsummer fra 10 studenter og skrive ut karakteren (eller feilmelding) etter hver innlesing. 
 *    HINT: hvordan kan du bruke en for-løkke til dette.
 *    
 * c) Legg inn kontroll på innlesinga i programmet i pkt. b) slik at ugyldige poengsummer (negativ verdi eller over 100) må leses inn på nytt.
 */
import static javax.swing.JOptionPane.*;

public class oppgaveB5 {

	public static void main(String[] args) {
		String melding = "karakterer:\n";

		
		for (int i=1; i <= 10; i++) {
			int poengsum;
			String karakter = "AAA";
			do {
				poengsum = Integer.parseInt(showInputDialog(melding + "Skriv inn poengsum:"));
				if (poengsum > 100 || poengsum < 0) {
					showMessageDialog (null,"Ugydig poengsum.");
				}
			} while (poengsum > 100 || poengsum < 0);
			
			if (poengsum <= 100 && poengsum >= 90) {
				karakter = "A";
			} else if (poengsum <= 89 && poengsum >= 80) {
				karakter = "B";
			} else if (poengsum <= 79 && poengsum >= 60) {
				karakter = "C";
			} else if (poengsum <= 59 && poengsum >= 50) {
				karakter = "D";
			} else if (poengsum <= 49 && poengsum >= 40) {
				karakter = "E";
			} else if (poengsum <= 39) {
				karakter = "F";
			}
			melding += "student nr. " + i + ": " + karakter + "\n";
		}
		showMessageDialog(null,melding);
	}

}
