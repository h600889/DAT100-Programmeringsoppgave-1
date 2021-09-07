package no.hvl.dat100;

/*
 * Oppgave B4
 * Lag et program som leser inn bruttoinntekt, beregner og skriver ut trinnskatten.
 */

import static javax.swing.JOptionPane.*;

// jeg har tatt utgangspunkt i satsene på https://www.skatteetaten.no/satser/trinnskatt

public class oppgaveB4 {
	// variabler
		final static double TRINNSKATT_PROSENT_TRINN1 = 1.70 / 100;
		final static double TRINNSKATT_PROSENT_TRINN2 = 4.00 / 100;
		final static double TRINNSKATT_PROSENT_TRINN3 = 13.20 / 100;
		final static double TRINNSKATT_PROSENT_TRINN3_TF = 11.20 / 100;
		final static double TRINNSKATT_PROSENT_TRINN4 = 16.20 / 100;
			
		final static int TRINNSKATT1 = 184800;
		final static int TRINNSKATT2 = 260100;
		final static int TRINNSKATT3 = 651250;
		final static int TRINNSKATT4 = 1021550;
			
	
	public static void main(String[] args) {
		
		int brutto = Integer.parseInt(showInputDialog("Bruttoinntekt:"));
		
		double trinn4 = trinnskattUtregning(brutto,brutto,TRINNSKATT_PROSENT_TRINN4, TRINNSKATT4);
		double trinn3 = trinnskattUtregningTrinn3(brutto,previousTrinn(brutto, TRINNSKATT4),TRINNSKATT_PROSENT_TRINN3, TRINNSKATT_PROSENT_TRINN3_TF, TRINNSKATT3);
		double trinn2 = trinnskattUtregning(brutto,previousTrinn(brutto, TRINNSKATT3),TRINNSKATT_PROSENT_TRINN2, TRINNSKATT2);
		double trinn1 = trinnskattUtregning(brutto,previousTrinn(brutto, TRINNSKATT2),TRINNSKATT_PROSENT_TRINN1, TRINNSKATT1);
		
		int trinnskattBeløp = (int) ((trinn1 + trinn2 + trinn3 + trinn4) + 0.5);
		showMessageDialog(null, "beløp: " + trinnskattBeløp + "kr");
		

		
	}
	
	
	public static double trinnskattUtregning(int brutto, int previousTrinn, double TRINNSKATT_PROSENT_TRINN, int TRINNSKATT) {		
		if (brutto >= TRINNSKATT) {
			return (previousTrinn - TRINNSKATT) * TRINNSKATT_PROSENT_TRINN;
		}
		return 0.0;
	}
	
	public static double trinnskattUtregningTrinn3(int brutto, int previousTrinn, double TRINNSKATT_PROSENT_TRINN, double TRINNSKATT_PROSENT_TRINN_TF, int TRINNSKATT) {		
		if (brutto >= TRINNSKATT) {
			if (tromsOgFinnmark()) {
				return (previousTrinn - TRINNSKATT) * TRINNSKATT_PROSENT_TRINN_TF;
			}
			return (previousTrinn - TRINNSKATT) * TRINNSKATT_PROSENT_TRINN;
		}
		return 0.0;
	}
	
	public static int previousTrinn(int brutto, int TRINNSKATT) {
		if (brutto >= TRINNSKATT) {
			return TRINNSKATT;
		}
		return brutto;
	}
	
	public static Boolean tromsOgFinnmark() {
		// avgjør om brukeren bor i Troms og Finnmark, siden trinnskatt trinn 3 er annerledes i det tilfellet.
			String tromsOgFinnmark;
			
			do {
				tromsOgFinnmark = showInputDialog("Bor du i Troms og Finnmark? (J)a/(N)ei").toLowerCase();
				if (!tromsOgFinnmark.contains("j") && !tromsOgFinnmark.contains("n")) {
					showMessageDialog(null, "Vennligst skriv inn J for 'Ja', eller N for 'Nei'");
				}
			} while (!tromsOgFinnmark.contains("j") && !tromsOgFinnmark.contains("n"));
			boolean tromsOgFinnmarkBool = (tromsOgFinnmark.contains("j"));
			return tromsOgFinnmarkBool;
	}

}
