package xadrez.pecas;

import boardgame.Position;
import boardgame.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Position p = new Position(0, 0);
		
		// Acima
		p.setValor(position.getlinha() - 1, position.getcoluna());
		while (getTabuleiro().positionExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
			p.setlinha(p.getlinha() - 1);
		}
		if(getTabuleiro().positionExiste(p) && existePecaOponente(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
		}
		
		// Esquerda
		p.setValor(position.getlinha(), position.getcoluna() - 1);
		while (getTabuleiro().positionExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
			p.setcoluna(p.getcoluna() - 1);
		}
		if(getTabuleiro().positionExiste(p) && existePecaOponente(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
		}
		
		// Direita
		p.setValor(position.getlinha(), position.getcoluna() + 1);
		while (getTabuleiro().positionExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
			p.setcoluna(p.getcoluna() + 1);
		}
		if(getTabuleiro().positionExiste(p) && existePecaOponente(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
		}
		
		// Baixo
		p.setValor(position.getlinha() + 1, position.getcoluna());
		while (getTabuleiro().positionExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
			p.setlinha(p.getlinha() + 1);
		}
		if(getTabuleiro().positionExiste(p) && existePecaOponente(p)) {
			mat[p.getlinha()][p.getcoluna()] = true;
		}
				
		
		
		
		return mat;
	}
	
}
