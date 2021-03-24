import java.util.ArrayList;
import java.util.List;


enum Rank{
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13),
	ACE(14);  //create enum of rank to get the values of each card in number
	
	int val;
	Rank(int val) {
		this.val=val;
	}
}

enum Suit{
	CLUBS,
	DIAMONDS,
	HEARTS,
	SPADES
}



public class Card {
	Rank rank;
	 Suit suit;
	
	public Card(Rank rank,Suit suit)
	{
		this.rank=rank;
		this.suit=suit;
	}
	
	public Rank rank() {
		return rank;
	}
	
	public Suit suit() {
		return suit;
	}
	
	public String toString() {
		return rank+"of" +suit;
	}
}
