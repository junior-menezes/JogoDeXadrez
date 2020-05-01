package boardgame;

public class Peca {
	
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		position = null; //o java já faz essa inicialização como nulo
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	
}
