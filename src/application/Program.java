package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while (true) {
			try {
				UI.limpaTela();
				UI.printPartida(partida);
				System.out.println();
				System.out.print("Entrada: ");
				XadrezPosition entrada = UI.leiaXadrezPosition(sc);
				
				boolean[][] possiveisMovimentos = partida.possiveisMovimentos(entrada);
				UI.limpaTela();
				UI.printTabuleiro(partida.getPecas(), possiveisMovimentos);
				
				System.out.println();
				System.out.print("Alvo: ");
				XadrezPosition alvo = UI.leiaXadrezPosition(sc);
				
				PecaDeXadrez pecaCapturada = partida.movimentoXadrezPosition(entrada, alvo);
			}
			catch(TabuleiroException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}			
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
			
			
		}
		
		
		
		

	}

}
