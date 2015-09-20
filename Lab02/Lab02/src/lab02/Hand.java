package lab02;



public class Hand {
	
	private Card[] cardHand = new Card[5];
	
	public Hand(Deck x){
		for(int i=0; i<=4; i++){
			cardHand[i] = x.draw();
		}
	}
	
	public String score(){
		
		String result = "";
		
		int rank[] = new int [13];
		int suit[] = new int [4];
		
		
		
		return result;
	}

}
