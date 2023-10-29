package com.zaradev.pendu;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {
	private final List<Character> secretWord = new ArrayList<>();
	private int lifePoints;
	private List<Character> guessWord = new ArrayList<>();	
	
	public GuessGame(String wordToGuess, int lifePoints) {
		for(char c : wordToGuess.toCharArray()) {
			this.secretWord.add(c);
		}
		
		this.lifePoints = lifePoints;
		
		for(int index = 0; index < secretWord.size(); index++) {
			this.guessWord.add('_');
		}
		
	}

	@Override
	public String toString() {
		return "GuessGame [lifePoints=" + lifePoints + ", guessWord=" + guessWord + "]";
	}

	public void guessLetter(char letter) {
		if(secretWord.contains(letter) && !guessWord.contains(letter)) {
			int index = 0;
			for(char c : secretWord) {
				if(c == letter) {
					guessWord.set(index, c);
				}
				index++;
			}	
		}else {
			lifePoints -=1;
		}
		
	}

	public boolean isLost() {
		return lifePoints <= 0;
	}

	public boolean isWon() {
		return ! guessWord.contains('_');
	}

	

}
