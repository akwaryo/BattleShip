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
	
	// Adicionando os Painéis
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	Container cp;
	
	// Adicionando os Botões
	JButton[][] Botoes = new JButton[10][10];
	JButton novo = new JButton("Novo Jogo");
	JButton voltar = new JButton("Voltar");
	
	// Adicionando as Labels
	JLabel naviosRestantes = new JLabel("Navios Restantes");
	JLabel tirosRestantes = new JLabel("Tiros Restantes");
	JLabel contNavios = new JLabel("");
	int contadorNavio = 19;
	JLabel contTiros = new JLabel("");
	int contadorTiro = 30;
	
	// Vetor que fica por trás dos Botões e guarda água ou navios
	int vetor[][] = new int[10][10];
	int pontuacao = 0;
	
	// Instanciando classe jogo que preenche o vetor e distribui os navios
	Jogo jogo = new Jogo();		

	public Tabuleiro(){
		
		// Titulo da janela
		setTitle("Batalha Naval");
		//Define o tamanho da janela. Pode ser usado o janela.pack() para auto ajuste
		setSize(507, 415);		
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
		grid.setBounds(3, 58, 497, 325);
		grid.setLayout(new GridLayout(10, 10, 2, 2));
		
		// Adiciona os Botões no Grid
		for(int linha = 0; linha < 10; linha++){
			for(int coluna = 0; coluna < 10; coluna++){
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}
		
		// Botão Novo Jogo
		novo.setBounds(7, 14, 96, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);
		
		// Botão Voltar
		voltar.setBounds(398, 14, 96, 35);
		voltar.setFocusable(false);
		voltar.addActionListener(this);
		
		// Label Navios Restantes		
		naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		naviosRestantes.setBounds(120, 10, 120, 18);
		
		// Label Tiros Restantes
		tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		tirosRestantes.setBounds(272, 10, 118, 18);
		
		// Contador Navios Restantes
		contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
		contNavios.setBounds(170, 28, 20, 26);
		contNavios.setText("" + contadorNavio);
		
		// Contaddor Tiros Restantes
		contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
		contTiros.setBounds(320, 28, 20, 26);
		contTiros.setText("" + contadorTiro);
		
		// Adicionando os elementos no Container
		cp.add(grid);
		cp.add(novo);
		cp.add(voltar);
		cp.add(naviosRestantes);
		cp.add(tirosRestantes);
		cp.add(contNavios);
		cp.add(contTiros);
		
		// Chamando o método que inicia o jogo e distribui os navios
		jogo.iniciaJogo(vetor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Função do botão Voltar
		if (e.getSource() == voltar){
			this.dispose();
		}
		
		// Função dos Botões do Tabuleiro
		for(int linha = 0; linha < 10; linha++){
			for(int coluna = 0; coluna < 10; coluna++){
				
				// Quando um Botão é clicado
				if (e.getSource() == Botoes[linha][coluna]) {
					
					// Decrementando o número de tiros restantes
					--contadorTiro;
					contTiros.setText("" + contadorTiro);
					
					// Se for 0, acerta a água e mostra vazio
					if (vetor[linha][coluna] == 0){
						Botoes[linha][coluna].setEnabled(false);
					}
					// Se não for 0, mostra a imagem de navio destruído
					else if (vetor[linha][coluna] != 0) {
						Botoes[linha][coluna].setIcon(
								new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));
						contNavios.setText("" + --contadorNavio);
						pontuacao++;
					}
					
					// Finaliza o jogo depois de 30 tiros
					if (contadorTiro == 0){
						// Mostra mensagem de fim de jogo
						JOptionPane.showMessageDialog(this, "Fim de Jogo. Sua pontuação: " + pontuacao,
								"Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
						
						// Grava a pontuação no arquivo
						
						// Reinicia o jogo
						this.dispose();
						// Cria um novo tabuleiro e seta a visibilidade
						Tabuleiro tabuleiro = new Tabuleiro();
						tabuleiro.setVisible(true);
					}
				}
			}
		}
		
		// Função do Botão Novo Jogo
		if (e.getSource() == novo){
			// Fecha a janela
			this.dispose();
			
			// Cria um novo tabuleiro e seta a visibilidade
			Tabuleiro tabuleiro = new Tabuleiro();
			tabuleiro.setVisible(true);
			
			// Mostra mensagem de Jogo Reiniciado
			JOptionPane.showMessageDialog(this, "Jogo reiniciado!",
					"Novo Jogo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
