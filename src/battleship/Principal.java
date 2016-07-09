package battleship;

import javax.swing.SwingUtilities;

import telas.TelaInicial;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Inicia a Tela Inicial
				TelaInicial telaInicial = new TelaInicial();				
				// Deixa a janela vis�vel
				telaInicial.setVisible(true);
			}
		});		
	}

}
