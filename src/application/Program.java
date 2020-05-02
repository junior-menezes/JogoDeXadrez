package application;

import java.util.Scanner;

import boardgame.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while (true) {
			UI.printTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Entrada: ");
			XadrezPosition entrada = UI.leiaXadrezPosition(sc);
			
			System.out.println();
			System.out.print("Alvo: ");
			XadrezPosition alvo = UI.leiaXadrezPosition(sc);
			
			PecaDeXadrez pecaCapturada = partida.movimentoXadrezPosition(entrada, alvo);
			
		}
		

	}

}
