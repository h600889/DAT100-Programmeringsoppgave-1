package no.hvl.dat100;

/*
 * Oppgave B4
 * Lag et program som leser inn bruttoinntekt, beregner og skriver ut trinnskatten.
 */

import static javax.swing.JOptionPane.*;

// jeg har tatt utgangspunkt i satsene på https://www.skatteetaten.no/satser/trinnskatt

public class oppgaveB4 {

	public static void main(String[] args) {
		
		int brutto = Integer.parseInt(showInputDialog("Bruttoinntekt:"));
		showMessageDialog(null, trinnskattUtregning(brutto, tromsOgFinnmark()));
		
	}
	
	
	public static String trinnskattUtregning(int brutto, boolean tromsOgFinnmarkBool) {
		// variabler
		String trinnskattProsent = "Trinn 0";
		
		final double TRINNSKATT_PROSENT_TRINN1 = 1.70 / 100;
		final double TRINNSKATT_PROSENT_TRINN2 = 4.00 / 100;
		final double TRINNSKATT_PROSENT_TRINN3 = 13.20 / 100;
		final double TRINNSKATT_PROSENT_TRINN3_TF = 11.20 / 100;
		final double TRINNSKATT_PROSENT_TRINN4 = 16.20 / 100;
		
		final int TRINNSKATT1 = 184800;
		final int TRINNSKATT2 = 260100;
		final int TRINNSKATT3 = 651250;
		final int TRINNSKATT4 = 1021550;
		
		double trinn1 = 0.0;
		double trinn2 = 0.0;
		double trinn3 = 0.0;
		double trinn4 = 0.0;
		int previousTrinn = brutto;
		
		
			 //trinn v2
			//trinn 4
		if (brutto >= TRINNSKATT4) {
			trinn4 = (previousTrinn - TRINNSKATT4) * TRINNSKATT_PROSENT_TRINN4;
			previousTrinn = TRINNSKATT4;
			trinnskattProsent = "Trinn 4";
		}
			//trinn 3
		if (brutto >= TRINNSKATT3) {
			if (tromsOgFinnmarkBool) {
				trinn3 = (previousTrinn - TRINNSKATT3) * TRINNSKATT_PROSENT_TRINN3_TF;
			} else {
				trinn3 = (previousTrinn - TRINNSKATT3) * TRINNSKATT_PROSENT_TRINN3;
			}
			if (brutto < TRINNSKATT4) {
				trinnskattProsent = "Trinn 3";
			}
			previousTrinn = TRINNSKATT3;
		}
			//trinn 2
		if (brutto >= TRINNSKATT2) {
			trinn2 = (previousTrinn - TRINNSKATT2) * TRINNSKATT_PROSENT_TRINN2;
			if (brutto < TRINNSKATT3) {
				trinnskattProsent = "Trinn 2";
			}
			previousTrinn = TRINNSKATT2;
		}
		
			//trinn 1
		if (brutto >= TRINNSKATT1) {
			trinn1 = (previousTrinn - TRINNSKATT1) * TRINNSKATT_PROSENT_TRINN1;
			if (brutto < TRINNSKATT2) {
				trinnskattProsent = "Trinn 1";
			}
		}
		
		// jeg vet ikke egentlig helt hvordan trinnskatt fungerer så dette er kanskje ikke en riktig utregning av trinnskattsbeløpet.
			// JEG HAR LEST SÅ MYE OM TRINNSKATT DETTE ER RIKTIG *OG* HVORDAN DET FUNGERER *OG* EN RIKTIG UTREGNING FUCK U OLD TESS
		int trinnskattBeløp = (int) ((trinn1 + trinn2 + trinn3 + trinn4) + 0.5);
		
		String melding = trinnskattProsent + "\nbeløp: " + trinnskattBeløp + "kr";
		return melding;
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
