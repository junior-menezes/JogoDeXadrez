package boardgame;

public class Position {
	private int linha;
	private int coluna;
	
	
	public Position(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}


	public int getlinha() {
		return linha;
	}


	public void setlinha(int linha) {
		this.linha = linha;
	}


	public int getcoluna() {
		return coluna;
	}


	public void setcoluna(int coluna) {
		this.coluna = coluna;
	}
	
	public void setValor(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		
	}
	
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}
	
}
