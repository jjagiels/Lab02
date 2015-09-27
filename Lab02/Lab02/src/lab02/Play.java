package lab02;

import java.util.ArrayList;
import java.util.Comparator;

public class Play {
	public static void main(String[] args){
		Deck a = new Deck();
		a.Shuffle();
		Hand h1 = new Hand(a);
		Hand h2 = new Hand(a);
		System.out.println(h1.toString());
		System.out.println(h1.score());
		System.out.println(h2.toString());
		System.out.println(h2.score());
		compare(h1,h2);
	}
			
	public static void compare(Hand h1, Hand h2){
		double result = 0;
		double hiHandWinner = 0;
		
		result = h2.score() - h1.score();
		
		if(result > 0){
			System.out.println("Hand 2 wins");
		}
		else if (result < 0){
			System.out.println("Hand 1 wins");
		}
		else if (result == 0){
			hiHandWinner = h1.score();
		}
	}
}