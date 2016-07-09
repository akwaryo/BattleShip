package battleship;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	
	private Random generate = new Random();
	
	public void iniciaJogo(int[][] vetor){		
		
		// Cria a posição do navio no tabuleiro
		int linha = generate.nextInt(10); // Linha
		int coluna = generate.nextInt(10); // Coluna
		boolean cabe = false;
		
		// Criando ArrayList com navios
		ArrayList<Navio> navios = new ArrayList<>();
		
		// Adicionando navios na Lista
		navios.add(new Destroyer());
		navios.add(new Fragata());
		navios.add(new Submarino());
		
		// Preenche o vetor com Zeros (0)
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		
		for(int cont = 0; cont < navios.size(); cont++){
			int contador = 0;
			while(navios.get(cont).getQtdDeNavios() > contador) {				
				
				// Cria a orientação do Navio. 0 Vertical. 1 Horizontal
				int orientacao = generate.nextInt(2);
				
				// Verifica se o navio cabe na posição do tabuleiro criada
				cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
				
				// Se o Navio não couber, gera outra posição
				if(cabe == false){
					while(cabe == false){
						linha = generate.nextInt(10); // Linha
						coluna = generate.nextInt(10); // Coluna
						cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
					}
				}
				
				// Se o Navio couber, distribui os navios 
				if (orientacao == 0){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						linha++;
					}
				}
				
				else if (orientacao == 1){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						coluna++;
					}
				}
				contador++;
			}
		}
	}
	
	public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]){
		// Se a orientação for Vertical, trava a coluna e incrementa a linha
		if (orientacao == 0){
			if (linha > (9 - tamanho)){
				return false;
			}
			for (int row = 0; row < tamanho; row++){
				if (vetor[linha][coluna] == 0){
					linha++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		
		// Se a orientação for Horizontal, trava a linha e incrementa a coluna
		if (orientacao == 1){
			if (coluna > (9 - tamanho)){
				return false;
			}
			for (int col = 0; col < tamanho; col++){
				if (vetor[linha][coluna] == 0){
					coluna++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
