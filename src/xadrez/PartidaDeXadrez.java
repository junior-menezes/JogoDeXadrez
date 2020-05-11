package xadrez;

import boardgame.Peca;
import boardgame.Position;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private int turno;
	private Color jogadorAtual;
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Color.BRANCO;
		configuracaoInicial();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Color getJogadorAtual() {
		return jogadorAtual;
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
	
	public boolean[][] possiveisMovimentos(XadrezPosition entradaPosition){
		Position position = entradaPosition.convertePosition(); //toPosition
		validaPosicaoEntrada(position);
		return tabuleiro.peca(position).possiveisMovimentos();
	}
	
	public PecaDeXadrez movimentoXadrezPosition(XadrezPosition entradaPosition, XadrezPosition alvoPosition) { //PerformChessMove
		Position entrada = entradaPosition.convertePosition();
		Position alvo = alvoPosition.convertePosition();
		validaPosicaoEntrada(entrada);
		validaPosicaoAlvo(entrada, alvo);
		Peca pecaCapiturada = fazMovimento(entrada, alvo);
		proximoturno();
		return (PecaDeXadrez) pecaCapiturada;
	}
	
	

	private Peca fazMovimento(Position entrada, Position alvo) {
		Peca p = tabuleiro.removePeca(entrada);
		Peca pecaCapiturada = tabuleiro.removePeca(alvo);
		tabuleiro.substituiPeca(p, alvo);
		return pecaCapiturada;
		
	}
	
	private void validaPosicaoEntrada(Position position) {
		if(!tabuleiro.existePeca(position)) {
			throw new TabuleiroException("Nao ha peca na posicao de origem");
		}
		
		if (jogadorAtual != ((PecaDeXadrez)tabuleiro.peca(position)).getColor()){
			throw new XadrezException("A peca escolhida nao eh sua!");
		}
		
		if(!tabuleiro.peca(position).existeAlgumPossivelMovimento()) {
			throw new XadrezException("Nao ha um movimento posssivel para essa peca. Peca travada!");
		}
	}
	
	private void validaPosicaoAlvo(Position entrada, Position alvo) {
		if(!tabuleiro.peca(entrada).possiveisMovimento(alvo)) {
			throw new XadrezException("A peca escolhida nao pode ser movida para esta posicao.");
		}
		
	}
	
	private void proximoturno() {
		turno++;
		jogadorAtual = (jogadorAtual == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
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
