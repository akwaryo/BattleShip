package battleship;
/**
 * Classe que adiciona os objetos {@link #Jogador() Jogador} na lista de jogadores,
 * persiste a lista em arquivo e busca no arquivo a lista de jogadores.
 * <p> Implementa o Padrão Singleton, para que um jogador seja instanciado apenas uma vez e possa
 * realizar vários jogos em sequência. 
 * @author Rodrigo Lima
 * @see Jogador
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Pontuacao {
	
	private static Pontuacao instancia;	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	/**
	 * Construtor vazio para implementação do padrão Singleton.
	 */
	public Pontuacao(){
	}
	
	/**
	 * Padrão Singleton para instanciar apenas uma Pontuação.
	 * @return Variável estática instancia.
	 */
	public static synchronized Pontuacao getInstance(){
		if (instancia == null) {
			instancia = new Pontuacao();
		}
		return instancia;
	}	
	
	/**
	 * Método que adiciona objetos do tipo Jogador na Lista.
	 * @param jogador Jogador jogador.
	 */
	public void adicionaJogador(Jogador jogador){
		jogadores.add(jogador);
	}
	
	/**
	 * Método que persiste a lista de jogadores em arquivo.
	 * <p> Este método verifica o arquivo antes de sobrescrever uma nova lista, se já houver 
	 * objetos no arquivo, eles são salvos numa lista temporária e reescritos concatenados com a 
	 * nova lista.
	 */
	public void salvaLista(){
		
		// Cria Array temporário para guardar jogadores já salvos
		ArrayList<Jogador> arquivo = getJogadores();
		
		// Se o arquivo não estiver vazio, concatena os novos jogadores com os que existiam
		if (arquivo != null && !arquivo.isEmpty()){
			try {
				FileOutputStream file = new FileOutputStream("ranking.sav");
				ObjectOutputStream stream = new ObjectOutputStream(file);
				// Concatena as listas de jogadores
				jogadores.addAll(arquivo);
				stream.writeObject(jogadores);
				stream.close();
				file.close();
			} catch (Exception e){
				System.out.println("Erro ao acessar o arquivo.");
			}
		}
		
		// Se o arquivo estiver vazio, cria um novo e preenche com a lista de jogadores
		try {
			FileOutputStream file = new FileOutputStream("ranking.sav");
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(jogadores);
			stream.close();
			file.close();
		} catch (Exception e){
			System.out.println("Erro ao acessar o arquivo.");
		}
	}

	/**
	 * Método que busca a lista de jogadores no arquivo.
	 * <p> Este método é utilizado pelo método salvaLista para verificar se 
	 * existe lista já persistida no arquivo, se não houver ele retorna uma lista null.
	 * @return Retorna a lista de jogadores buscada no arquivo, se não existir retorna null.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Jogador> getJogadores(){
		ArrayList<Jogador> jog = null;
		try {
			FileInputStream file = new FileInputStream("ranking.sav");
			ObjectInputStream in = new ObjectInputStream(file);
			jog = (ArrayList<Jogador>) in.readObject();
			in.close();
			file.close();
		} catch (Exception e){
		}
		return jog;
	}
}

