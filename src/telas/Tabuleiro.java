package telas;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import battleship.Jogo;

public class Tabuleiro extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	JButton[][] Botoes = new JButton[10][10];
	JButton novo = new JButton("Novo Jogo");
	JButton voltar = new JButton("Voltar");
	int vetor[][] = new int[10][10];
	Container cp;

	public Tabuleiro(){
		
		// Titulo da janela
		setTitle("Batalha Naval");
		//Define o tamanho da janela. Pode ser usado o janela.pack() para auto ajuste
		setSize(507, 409);
		
		//Centraliza a janela. Pode ser usado o janela.setLocation() para colocar onde quiser
		setLocationRelativeTo(null);
		
		//Configura o maximizar e fixa o tamanho da janela
		setResizable(false);
		
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Configura o Container
		setContentPane(jContentPane);
		cp = getContentPane();
		cp.setLayout(null);
		
		// Configura o Grid de Botões
		grid.setBounds(3, 53, 497, 325);
		grid.setLayout(new GridLayout(10, 10, 2, 2));
		
		// Adiciona os Botões
		for(int linha = 0; linha < 10; linha++){
			for(int coluna = 0; coluna < 10; coluna++){
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}
		
		// Botão Novo Jogo
		novo.setBounds(7, 10, 100, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);
		
		// Botão Sair
		voltar.setBounds(394, 10, 100, 35);
		voltar.setFocusable(false);
		voltar.addActionListener(this);
		
		// Label
		JLabel lblBatalhaNaval = new JLabel("Batalha Naval");
		lblBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 18));
		lblBatalhaNaval.setBounds(182, 11, 120, 29);
		
		// Adicionando os elementos no Container
		cp.add(grid);
		cp.add(novo);
		cp.add(voltar);
		cp.add(lblBatalhaNaval);
		
		Jogo jogo = new Jogo();
		jogo.iniciaJogo(vetor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar){
			this.dispose();
		}
		
		for(int linha = 0; linha < 10; linha++){
			for(int coluna = 0; coluna < 10; coluna++){
				if (e.getSource() == Botoes[linha][coluna]) {
					if (vetor[linha][coluna] == 0){
						Botoes[linha][coluna].setEnabled(false);
					}
					else if (vetor[linha][coluna] != 0) {
						Botoes[linha][coluna].setIcon(
								new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));
					}
				}
			}
		}
	}
}
