package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class OppgaveO3 {

	public static void main(String[] args) {
		int n = 0;
		int nF = 1;
		do {
			n = Integer.parseInt(showInputDialog("Skriv inn et tall:"));
		} while (!(n > 0));

		for (int i = 1; i <= n; i++) {
			nF *= i;
		}
		showMessageDialog(null, nF);
	}

}
