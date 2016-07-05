package battleship;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Tabuleiro thisClass = new Tabuleiro();
				
				// Configura o fechamento da janela
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// Deixa a janela visível
				thisClass.setVisible(true);
			}
		});		
	}

}
