package boardgame;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na criação do tabuleiro: Tem que ter pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.pecas = new Peca[linhas][colunas];
	}


	public int getLinhas() {
		return linhas;
	}



	public int getColunas() {
		return colunas;
	}

	
	public Peca peca(int linha, int coluna) {
		if (!positionExiste(linha, coluna)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Position position) {
		if (!positionExiste(position)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		return pecas[position.getlinha()][position.getcoluna()];
	}
	
	public void substituiPeca(Peca peca, Position position) {
		if(existePeca(position)) {
			throw new TabuleiroException("Já existe uma peça na posição " + position);
		}
		pecas[position.getlinha()][position.getcoluna()] = peca;
		peca.position = position;
	}
	
	public Peca removePeca(Position position) {
		if (!positionExiste(position)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		if(peca(position) == null) {
			return null;
		}
		Peca aux = peca(position);
		aux.position = null;
		pecas[position.getlinha()][position.getcoluna()] = null;
		return aux;
	}
	
	public boolean positionExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean positionExiste(Position position) {
		return positionExiste(position.getlinha(), position.getcoluna());
	}
	
	public boolean existePeca(Position position) {
		if (!positionExiste(position)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		return peca(position) != null;
	}
	
	
}
