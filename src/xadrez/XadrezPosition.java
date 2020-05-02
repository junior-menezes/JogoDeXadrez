package xadrez;

import boardgame.Position;

public class XadrezPosition {
	private char coluna;
	private int linha;

	public XadrezPosition(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro instanciando a posição do Xadrez");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	protected Position convertePosition() {
		return new Position(8 - linha, coluna - 'a');
	}
	
	protected static XadrezPosition daPosition(Position position) {
		return new XadrezPosition((char) ('a' - position.getcoluna()), 8 - position.getlinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}