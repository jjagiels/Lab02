package lab02;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//private ArrayList deck;
	private ArrayList<Card> cardDeck = new ArrayList<Card>();
	
	public Deck(){
		String[] suits = {"diamond","heart","clubs","spade"};
		int j = 0;
		for(String suit : suits){
			for (int i=2;i<=14;i++){
				Card c = new Card(i, suit, j);
				this.cardDeck.add(c);
				j++;
			}
		}
	}
	public void Shuffle(){
		Collections.shuffle(cardDeck);
	}
	
	public Card draw(){
		Card nextCard = cardDeck.get(0);
		cardDeck.remove(0);
		return nextCard;
	}
	
	public int cardsLeft(){
		return cardDeck.size();
	}
}
