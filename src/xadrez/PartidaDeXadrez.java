package xadrez;

import boardgame.Tabuleiro;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
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
}
