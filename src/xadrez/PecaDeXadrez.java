package xadrez;

import boardgame.Peca;
import boardgame.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {
	
	private Color color;

	public PecaDeXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	
	
}
