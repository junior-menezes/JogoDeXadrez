package xadrez;

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
	
	private void substituiNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.substituiPeca(peca, new XadrezPosition(coluna, linha).convertePosition());
	}
	
	public void configuracaoInicial() {
		//substituiNovaPeca('b', 6, new Torre(tabuleiro, Color.BRANCO));
		//substituiNovaPeca('e', 8, new Rei(tabuleiro, Color.PRETO));
		//substituiNovaPeca('e', 1, new Rei(tabuleiro, Color.BRANCO));
		
		
		substituiNovaPeca('c', 2, new Torre(tabuleiro, Color.BRANCO));
		substituiNovaPeca('c', 1, new Torre(tabuleiro, Color.BRANCO));
        substituiNovaPeca('d', 2, new Torre(tabuleiro, Color.BRANCO));
        substituiNovaPeca('e', 2, new Torre(tabuleiro, Color.BRANCO));
        substituiNovaPeca('e', 1, new Torre(tabuleiro, Color.BRANCO));
        substituiNovaPeca('d', 1, new Rei(tabuleiro, Color.BRANCO));

        substituiNovaPeca('c', 7, new Torre(tabuleiro, Color.PRETO));
        substituiNovaPeca('c', 8, new Torre(tabuleiro, Color.PRETO));
        substituiNovaPeca('d', 7, new Torre(tabuleiro, Color.PRETO));
        substituiNovaPeca('e', 7, new Torre(tabuleiro, Color.PRETO));
        substituiNovaPeca('e', 8, new Torre(tabuleiro, Color.PRETO));
        substituiNovaPeca('d', 8, new Rei(tabuleiro, Color.PRETO));
	}
}
