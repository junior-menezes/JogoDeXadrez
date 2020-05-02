package xadrez.pecas;

import boardgame.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{

	public Rei(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
}
