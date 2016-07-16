package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import battleship.Jogador;
import battleship.Pontuacao;
import java.awt.Font;
import java.awt.TextArea;

public class Ranking extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando painel para receber elementos
	private JPanel contentPane = new JPanel();
	// Criação do botão voltar
	private JButton voltar = new JButton("Voltar");
	// Criação da label Título
	private JLabel labelTitulo = new JLabel("Ranking Pontua\u00E7\u00E3o");
	// JScrollPane texto = new JScrollPane(caixaDeTexto);
	TextArea textArea = new TextArea();
	
	public Ranking() {
		
		// Configura o nome da Janela
		setTitle("Ranking");
		// Retira a opção de redimensionar a janela		
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		// Retira o layout do painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		// Botão voltar
		voltar.setBounds(396, 332, 95, 31);
		voltar.addActionListener(this);
		contentPane.add(voltar);
		
		// Label título
		labelTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		labelTitulo.setBounds(172, 11, 157, 29);
		contentPane.add(labelTitulo);		
		
		// Configurando o tamnho da área de texto e adicionando no painel
		textArea.setBounds(10, 46, 481, 269);
		contentPane.add(textArea);
		
		// Criação da lista com o ranking, buscando direto do arquivo
		ArrayList<Jogador> jogadores = new Pontuacao().getJogadores();
		
		// Ordenando os jogadores por maior pontuação com o metódo compareTo()
		Collections.sort(jogadores);
		
		// Criação de uma StringBuilder para concatenar todos os jogadores em uma String
		StringBuilder ranking = new StringBuilder();
		
		// Montagem da StringBuilder
		for (Jogador jog : jogadores){
			ranking.append(jog.getNome() + " 		" + jog.getPontuacao() + "\n");		
		}
		
		// Criação da String final que recebe o raning completo e mostra na TextArea
		String rankingFinal = ranking.toString();
		textArea.setText(rankingFinal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar){
			this.dispose();
		}
	}
}
