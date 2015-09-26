package lab02;



public class Card {

	private int rank;
	private String suit;
	private int ID;
	
		
	public int getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	public int getID() {
		return ID;
	}

	public Card (int rank, String suit, int ID){
		this.rank = rank;
		this.suit = suit;
		this.ID = ID;
	}
	public String toString(){
		return rank + " of " + suit;
	}
	
	
}