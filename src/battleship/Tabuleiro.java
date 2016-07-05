package battleship;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tabuleiro extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	JButton[] Botoes = new JButton[100];
	JButton novo = new JButton("Novo Jogo");
	JButton quit = new JButton("Sair");
	int[] Vetor = new int[100];
	Container cp;

	public Tabuleiro(){
		super("Batalha Naval");
		initialize();
	}
	
	private void initialize(){
		
		//Define o tamanho da janela. Pode ser usado o janela.pack() para auto ajuste
		setSize(504, 407);
		
		//Centraliza a janela. Pode ser usado o janela.setLocation() para colocar onde quiser
		setLocationRelativeTo(null);
		
		//Configura o maximizar e fixa o tamanho da janela
		setResizable(false);
		
		setContentPane(jContentPane);
		
		cp = getContentPane();
		cp.setLayout(null);
		
		grid.setBounds(3, 53, 497, 327);
		grid.setLayout(new GridLayout(10, 10, 2, 2));
		
		for (int i = 0; i < 100; i++) {
			Botoes[i] = new JButton("");
			Botoes[i].addActionListener(this);
			Botoes[i].setFocusable(false);
			grid.add(Botoes[i]);
		}
		
		// Botão Novo Jogo
		novo.setBounds(7, 10, 100, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);
		
		// Botão Sair
		quit.setBounds(117, 10, 100, 35);
		quit.setFocusable(false);
		quit.addActionListener(this);
		
		cp.add(grid);
		cp.add(novo);
		cp.add(quit);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
