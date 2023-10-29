package com.zaradev.pendu;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final Random random = new Random();
		final String[] words = "abuser crottes fleches continental babiole etoile bougie coup coeur malade".split(" ");
		final String wordToGuess = words[random.nextInt(words.length)];
		
		GuessGame game = new GuessGame(wordToGuess, 10);
		
		System.out.println("Debut du jeu du pendu !");
		
		while(true) {
			System.out.println(game);
			System.out.println("Entrez une lettre :");
			
			final char letter = scanner.nextLine().charAt(0);
			
			game.guessLetter(letter);
			
			if(game.isLost()) {
				System.out.println(game);
				System.out.println("Perdu !");
				break;
			}
			
			if(game.isWon()) {
				System.out.println(game);
				System.out.println("Gagne !");
				break;
			}
		}

	}

}
