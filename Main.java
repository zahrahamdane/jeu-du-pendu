package com.zaradev.pendu;

import java.util.Random;
import java.util.Scanner;

/**
 * Class of the entrypoint of the Guess Game.
 */
public class Main {
	
	  /**
     * Entry point of the Guess Game. Contains the main algorithm of the game.
     */
	public static void main(String[] args) {
		final Random random = new Random();
		final String[] words = "abuser crottes fleches continental babiole etoile bougie coup coeur malade".split(" ");
		String wordToGuess = words[random.nextInt(words.length)];
		
		GuessGame game = new GuessGame(wordToGuess, 10);
		
		System.out.println("Debut du jeu du pendu !");
		
		while(true) {
			System.out.println(game);
			
			final char letter = scanLetter("Entrez une lettre :");
			
			game.guessLetter(letter);
			
			if(game.isLost()) {
				System.out.println(game);
				System.out.println("Perdu !");
			}
			
			if(game.isWon()) {
				System.out.println(game);
				System.out.println("Gagne !");
			}
			
			if(game.isLost() || game.isWon()) {
				char replayAnswer = scanLetter("Voulez-vous rejouer ?");
				if(replayAnswer == 'y' || replayAnswer == 'Y' || replayAnswer == 'o' || replayAnswer == 'O') {
					wordToGuess = words[random.nextInt(words.length)];
					game = new GuessGame(wordToGuess, 10);
				}else {
					break;
				}
			}
		}

	}

	private static char scanLetter(String question) {
		final Scanner scanner = new Scanner(System.in);
		Character letter = null;
		do {
			System.out.println(question);
			String input = scanner.nextLine();
			if(input.length() == 1) {
				letter = input.charAt(0);
			}
		}while(letter == null);
		
		return letter;
	}

}
