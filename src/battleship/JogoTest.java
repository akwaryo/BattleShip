package battleship;
/**
 * Classe de teste que implementa os testes dos métodos da classe Jogo.
 * @author Rodrigo Lima
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	
	Jogo jogo;
	int[][] vetor = new int[10][10];	
	
	/**
	 * Método de configuração que lança exceção para possíveis erros e instancia a classe Jogo.
	 * @throws Exception Lança exceção de erro durante a execução dos testes.
	 */
	@Before
	public void setUp() throws Exception{
		jogo = new Jogo();
	}
	
	/**
	 * Método de teste que testa se o retorno do método cabeNavio é falso.
	 * <p> Foi passado como parâmetro valores que estouram o limite da matriz, retornando falso.
	 */
	@Test
	public void testCabeNavioFalse(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(false, jogo.cabeNavio(3, 7, 1, 5, vetor));
	}
	
	/**
	 * Método de teste que testa se o retorno do método cabeNavio é verdadeiro.
	 * <p> Nesse caso é testado se o funcionamento está consistente, passando um vetor vazio e as posições
	 * dentro do limites da matriz.
	 */
	@Test
	public void testCabeNavioTrue(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(true, jogo.cabeNavio(3, 2, 1, 3, vetor));
		
	}
}
