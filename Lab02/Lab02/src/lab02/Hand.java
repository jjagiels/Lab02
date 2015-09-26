package lab02;

import java.util.Arrays;

public class Hand {
	
	private Card[] cardHand = new Card[5];
	
	public Hand(Deck x){
		for(int i=0; i<=4; i++){
			cardHand[i] = x.draw();
		}
	}
	
	public Hand(Card[] y){
		for(int i=0; i<=4; i++){
			cardHand[i] = y[i];
		}
	}
	
	public String score(){
		
		String result = "";
		
		int rank[] = new int [13];
		int suit[] = new int [4];
		
		this.sort();
		
		for(int i = 0; i<=4;i++){
/*			if(rank[cardHand[i].getRank()] == null){
				rank[cardHand[i].getRank()] = 0;
			}*/
			rank[cardHand[i].getRank()-2]++;
		}
		
		//Hand scoring begins here.
		
		//Check Royal Flush
		boolean flush = false;
		
		if(cardHand[0].getSuit().equals(cardHand[4].getSuit()))
			flush = true;
		
		boolean straight = false;
		
		int sortedRanks[] = new int [5];
		for(int i = 0; i<=4; i++){
			sortedRanks[i] = cardHand[i].getRank();
		}
		int straightArray[] = new int [5];
		
		Arrays.sort(sortedRanks);
		
		int firstCard = sortedRanks[0];
		
		for(int i = 0; i<=4; i++){
			straightArray[i] = i;
			sortedRanks[i] -= firstCard;
		}
		if(sortedRanks.equals(straightArray))
			straight=true;
		
		if(firstCard == 10 && straight && flush)
			return "Royal Flush";
		//End Check Royal Flush
		
		//Check Straight Flush
		if(straight && flush)
			return "Straight Flush";
		//End Check Straight Flush
		
		//Check Four of a Kind
		for(int numberOfRanks : rank){
			if(numberOfRanks == 4){
				return "Four of a Kind";
			}
		}
		//End Check Four of a Kind
		
		//Check Full House
		boolean threeOfAKind = false;
		boolean pair = false;
		for(int numberOfRanks : rank){
			if(numberOfRanks == 3){
				 threeOfAKind = true;
			}
			if(numberOfRanks == 2){
				pair = true;
			}
		}
		if (pair && threeOfAKind){
			return "Full House";
		}
		//End Check Full House
		
		//Check Flush
		if(flush)
			return "Flush";
		//End Check Flush
		
		//Check Straight
		if(straight)
			return "Straight";
		//End Check Straight
		
		//Check Three of a Kind
		if(threeOfAKind)
			return "Three of a Kind";
		//End Check Three of a Kind
		
		//Check Two Pair
		int paircount = 0;
		for(int numberOfRanks : rank){
			if(numberOfRanks==2)
				paircount++;
		}
		if(paircount==2)
			return "Two Pair";
		//End Check Two Pair
		
		//Check Pair
		if(pair)
			return "One Pair";
		//End Check Pair
		
		//Check High Card
		for(int i = 12; i>=0; i--){
			if(rank[i] > 0)
				return (i+2)+"";
		}
		return "Something went wrong, you get to rummage through code now for three hours.";
	}
	public void sort(){
		for(int i=0; i<cardHand.length -1 ;i++){
			int index = i;
			for (int j = i+1; j<cardHand.length; j++)
				if(cardHand[j].getID()<cardHand[index].getID())
					index = j;
			Card smallerCard = cardHand[index];
			cardHand[index] = cardHand[i];
			cardHand[i] = smallerCard;
		}
	}
	public String toString(){
		String whatsInTheHand = "";
		for(Card inTheHand : cardHand){
			whatsInTheHand += inTheHand.toString() + "\n";
		}
		return whatsInTheHand;
	}

}
