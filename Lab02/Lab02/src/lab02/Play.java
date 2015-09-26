package lab02;

import java.util.ArrayList;

public class Play {
	public static void main(String[] args){
		Deck a = new Deck();
		a.Shuffle();
		Hand h = new Hand(a);
		System.out.println(h.toString());
		System.out.println(h.score());
	}
}
