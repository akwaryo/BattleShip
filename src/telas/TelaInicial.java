package telas;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton iniciarJogo = new JButton("Iniciar Jogo");

	public TelaInicial() {
		
		// Titulo da janela
		setTitle("Batalha Naval");
		// Retira a opção de redimensionar a janela
		setResizable(false);
		// Configura o término do programa quando fechado
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);
		
		// Cria um Painel por cima da janela para maniplar os elementos
		contentPane = new JPanel();
		// Retira a borda do painel
		contentPane.setBorder(null);
		// Retira o Layout do Painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(133, 141, 223, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBatalhaNaval = new JLabel("Batalha Naval");
		lblBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 18));
		lblBatalhaNaval.setBounds(182, 11, 120, 29);
		contentPane.add(lblBatalhaNaval);
		
		JLabel lblInsiraOUsurio = new JLabel("Insira o usu\u00E1rio:");
		lblInsiraOUsurio.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblInsiraOUsurio.setBounds(135, 116, 105, 14);
		contentPane.add(lblInsiraOUsurio);
		
		// Botão Iniciar Jogo		
		iniciarJogo.setBounds(182, 238, 111, 36);
		iniciarJogo.setFont(new Font("Roboto", Font.BOLD, 14));		
		iniciarJogo.addActionListener(this);		
		contentPane.add(iniciarJogo);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("Roboto", Font.BOLD, 14));
		btnRanking.setBounds(30, 238, 111, 36);
		btnRanking.setFocusable(false);
		contentPane.add(btnRanking);
		
		JButton btnFechar = new JButton("Fechar o Jogo");
		btnFechar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnFechar.setFocusable(false);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(327, 238, 111, 36);
		contentPane.add(btnFechar);
		
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		
		// Ativando a tecla Enter para Iniciar o Jogo
		getRootPane().setDefaultButton(iniciarJogo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// Evento quando pressionado o botão Iniciar Jogo
		if (e.getSource() == iniciarJogo){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {						
					Tabuleiro tabuleiro = new Tabuleiro();
					tabuleiro.setVisible(true);						
				}
			});
		}
		// Evento quando pressionado o botão 
	}
}
