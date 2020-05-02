package xadrez;

import boardgame.Position;
import boardgame.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}
	
	public PecaDeXadrez[][] getPecas(){
		PecaDeXadrez[][] matrix = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matrix[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return matrix;		
	}
	
	public void configuracaoInicial() {
		tabuleiro.substituiPeca(new Torre(tabuleiro, Color.BRANCO), new Position(2, 1));
		tabuleiro.substituiPeca(new Rei(tabuleiro, Color.PRETO), new Position(0,  4));
		tabuleiro.substituiPeca(new Rei(tabuleiro, Color.BRANCO), new Position(7,  4));
	}
}
