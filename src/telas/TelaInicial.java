package telas;
/**
 * Classe que implementa a Tela Inicial do jogo fornecendo uma interface para interação com o usuário.
 * <p> A classe extende o utilitário de interface swing JFrame e implementa a interface ActionListener,
 * que configura as ações de interação com o usuário.
 * @author Rodrigo Lima
 */

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando Painel para receber elementos
	private JPanel contentPane = new JPanel();
		
	// Criando Campo de texto para o Nome do Jogador
	private JTextField caixaDeTexto = new JTextField(20);
	
	// Criando Botões
	private JButton iniciarJogo = new JButton("Iniciar Jogo");
	private JButton fecharJogo = new JButton("Fechar Jogo");
	private JButton ranking = new JButton("Ranking");
	
	// Criando Labels
	private JLabel labelBatalhaNaval = new JLabel("Batalha Naval");
	private JLabel labelUsuario = new JLabel("Insira o usu\u00E1rio:");

	/**
	 * Construtor da classe TelaInicial que cria os elementos gráficos da janela.
	 */
	public TelaInicial() {
		
		// Titulo da janela
		setTitle("Batalha Naval");
		// Retira a opção de redimensionar a janela
		setResizable(false);
		// Configura o término do programa quando fechado
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);		
		
		// Retira a borda do painel
		contentPane.setBorder(null);
		// Retira o Layout do Painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		// Campo de entrada Nome do jogador
		caixaDeTexto.setBounds(133, 141, 223, 29);		
		contentPane.add(caixaDeTexto);	
		
		// Label Batalha Naval
		labelBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 18));
		labelBatalhaNaval.setBounds(182, 11, 120, 29);
		contentPane.add(labelBatalhaNaval);
		
		// Label Inserir usuário
		labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelUsuario.setBounds(135, 116, 105, 14);
		contentPane.add(labelUsuario);
		
		// Botão Iniciar Jogo		
		iniciarJogo.setBounds(182, 238, 111, 36);
		iniciarJogo.setFont(new Font("Verdana", Font.PLAIN, 12));		
		iniciarJogo.addActionListener(this);		
		contentPane.add(iniciarJogo);
		
		// Botão Ranking
		ranking.setFont(new Font("Verdana", Font.PLAIN, 12));
		ranking.setBounds(30, 238, 111, 36);
		ranking.setFocusable(false);
		ranking.addActionListener(this);
		contentPane.add(ranking);
		
		// Botão Fechar jogo
		fecharJogo.setBounds(327, 238, 120, 36);
		fecharJogo.setFont(new Font("Verdana", Font.PLAIN, 12));
		fecharJogo.setFocusable(false);		
		fecharJogo.addActionListener(this);		
		contentPane.add(fecharJogo);
		
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		
		// Ativando a tecla Enter para Iniciar o Jogo
		getRootPane().setDefaultButton(iniciarJogo);
		
	}
	/**
	 * Método que configura as ações dos botões da interface gráfica.
	 * <p> O botão Iniciar Jogo captura o nome do jogador informado pelo usuário e inicia uma Thread que 
	 * executa a classe Tabuleiro, passando o nome do jogador como parâmetro.
	 * <p> O botão Fechar Jogo fecha o jogo, finalizando todas as threads em execução.
	 * <p> O botão Ranking inicia uma Thread que executa a classe Ranking.
	 * @see Tabuleiro
	 * @see Ranking
	 */
	public void actionPerformed(ActionEvent e) {
		
		// Evento quando pressionado o botão Iniciar Jogo
		if (e.getSource() == iniciarJogo){
			
			// Criando String para guardar o nome do jogador
			String nomeJogador = caixaDeTexto.getText();
			
			// Se o campo de nome estiver vazio, pede um usuário válido
			if (nomeJogador.equals("")){
				JOptionPane.showMessageDialog(null, "Insira um usuário válido");
			}
			
			// Se o campo não estiver vazio, inicia um novo jogo
			if (!(nomeJogador.equals(""))){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {						
						Tabuleiro tabuleiro = new Tabuleiro(nomeJogador);
						tabuleiro.setVisible(true);						
					}
				});				
				// Limpa a caixa de texto
				caixaDeTexto.setText("");
			}			
		}
		
		// Evento quando pressionado o botão Fechar Jogo
		if (e.getSource() == fecharJogo){
			System.exit(0);
		}
		
		// Evento quando pressionado o botão Ranking
		if (e.getSource() == ranking){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Ranking ranking = new Ranking();
					ranking.setVisible(true);					
				}
			});
		}
	}
}
