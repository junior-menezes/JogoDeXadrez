package xadrez;

import boardgame.Peca;
import boardgame.Position;
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
	
	protected boolean existePecaOponente(Position position) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(position);
		return p != null && p.getColor() != color;
	}
	
	
}
