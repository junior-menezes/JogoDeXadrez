package boardgame;

public abstract class Peca {
	
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		position = null; //o java j� faz essa inicializa��o como nulo
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public abstract boolean[][] possiveisMovimentos();
	
	
	//abaixo est� sendo utilizado o hook Method, ao qual temos um metodo concreto chamando uma poss�vel implementa��o de uma
	//subclasse concreta da classe Peca.
	public boolean possiveisMovimento(Position position) {
		return possiveisMovimentos()[position.getlinha()][position.getcoluna()];
	}
	
	public boolean existeAlgumPossivelMovimento() {
	
		boolean[][] mat = possiveisMovimentos();
		
		
				
		for (int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if (mat[i][j] == true && mat != null) {
					return true;
				}
			}
		}
		
		return false;
	}
}
