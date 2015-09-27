package lab02;

import java.util.Arrays;

public class Hand {
	
	private static Card[] cardHand = new Card[5];
	
	public Hand(Deck x){
		for(int i=0; i<=4; i++){
			cardHand[i] = x.draw();
		}
		int[] rank = tally(cardHand);
	}
	public static int[] tally(Card[] cardHand){
		int rank[] = new int [13];
		//int suit[] = new int [4];
		
		sort(cardHand);
		
		for(int i = 0; i<=4;i++){
	/*			if(rank[cardHand[i].getRank()] == null){
				rank[cardHand[i].getRank()] = 0;
			}*/
			rank[cardHand[i].getRank()-2]++;
		}
		return rank;
	}
	
	public static boolean isRoyalFlush(Card[] cardHand){
		if(firstCard == 10 && isStraight() && isFlush())
			return true;
	}
	public static boolean isFlush(){
		boolean flush = false;
		
		if(cardHand[0].getSuit().equals(cardHand[4].getSuit()))
			flush = true;
	}
	
//	public Hand(Card[] y){
//		for(int i=0; i<=4; i++){
//			cardHand[i] = y[i];
//		}
//	}
	
	public double score(int[] rank){
		

		
		//Hand scoring begins here.
		
		//Check Royal Flush
	

		
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
			return 10;
		//End Check Royal Flush
		
		//Check Straight Flush
		if(straight && flush)
			return 9;
		//End Check Straight Flush
		
		//Check Four of a Kind
		for(int i = 0; i<=12; i++){
			if(rank[i] == 4){
				return 8;
			}
		}
		//End Check Four of a Kind
		
		//Check Full House
		boolean threeOfAKind = false;
		boolean pair = false;
		double hiHand = 0;
		double lowHand = 0;
		for(int i = 0; i<=12; i++){
			if(rank[i] == 3){
				 threeOfAKind = true;
				 hiHand = i+2;
			}
			if(rank[i] == 2){
				pair = true;
				lowHand = i+2;
			}
		}
		if (pair && threeOfAKind){
			return 7;
		}
		//End Check Full House
		
		//Check Flush
		if(flush)
			return 6;
		//End Check Flush
		
		//Check Straight
		if(straight)
			return 5;
		//End Check Straight
		
		//Check Three of a Kind
		if(threeOfAKind)
			return 4;
		//End Check Three of a Kind
		
		//Check Two Pair
		int paircount = 0;
		for(int numberOfRanks : rank){
			if(numberOfRanks==2)
				paircount++;
		}
		if(paircount==2)
			return 3;
		//End Check Two Pair
		
		//Check Pair
		if(pair)
			return 2;
		//End Check Pair
		
		//Check High Card
		for(int i = 12; i>=0; i--){
			if(rank[i] > 0){
				if(i+2 == 14)
					return 1.14;
				else if(i+2 == 13)
					return 1.13;
				else if(i+2 == 12)
					return 1.12;
				else if(i+2 == 11)
					return 1.11;
				else if(i+2 == 10)
					return 1.10;
				else if(i+2 == 9)
					return 1.09;
				else if(i+2 == 8)
					return 1.08;
				else if(i+2 == 7)
					return 1.07;
				else if(i+2 == 6)
					return 1.06;
				else if(i+2 == 5)
					return 1.05;
				else if(i+2 == 4)
					return 1.04;
				else if(i+2 == 3)
					return 1.03;
				else if(i+2 == 2)
					return 1.02;
				else
					return 1;
			}
		}
		return 0;
	}
	public static void sort(Card[] cardHand){
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
