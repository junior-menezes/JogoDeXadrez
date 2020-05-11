package xadrez.pecas;

import boardgame.Position;
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
	
	private boolean podeMover(Position position){
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(position);
		return p == null || p.getColor() != getColor();
	}
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Position p = new Position(0,0);
		
		//acima
		p.setValor(position.getlinha() - 1, position.getcoluna());
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//abaixo
		p.setValor(position.getlinha() + 1, position.getcoluna());
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//esquerda
		p.setValor(position.getlinha(), position.getcoluna() - 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//Direita
		p.setValor(position.getlinha(), position.getcoluna() + 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		
		//Noroeste - esquerda cima
		p.setValor(position.getlinha() - 1, position.getcoluna() - 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//Nordeste - direita cima
		p.setValor(position.getlinha() - 1, position.getcoluna() + 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//Sudoeste - esquerda baixo
		p.setValor(position.getlinha() + 1, position.getcoluna() - 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		//Sudoeste - direita baixo
		p.setValor(position.getlinha() + 1, position.getcoluna() + 1);
		if (getTabuleiro().positionExiste(p) && podeMover(p)) {
			mat[p.getlinha()][p.getcoluna()] = true; 
		}
		
		
		
		
		
		
		return mat;
	}
	
}
