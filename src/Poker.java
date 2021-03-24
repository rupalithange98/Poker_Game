import java.util.ArrayList;
import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Poker {
	//create arrayList of player
	static ArrayList<Players> playerList = new ArrayList();
	
	//create arraylist of playerScore
	static ArrayList<Integer> playerScore = new ArrayList();

	public static void shuffleDeck(CardDecks cat) //method to shuffle array of 52 cards randomly
	{
		for (int c = cat.cardsDeck.length - 1; c > 0; c--) {
			int rand = (int) (Math.random() * (c + 1));
			Card temp = cat.cardsDeck[c];
			cat.cardsDeck[c] = cat.cardsDeck[rand];
			cat.cardsDeck[rand] = temp;
		}
//		System.out.println(Arrays.toString(cardsDeck));

	}

	public static void fillDeck(CardDecks cd) //fill the deck with values of rank and suit..initially carddeck is empty
	{
		int i = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cd.cardsDeck[i] = new Card(r, s);
				i++;
			}
		}
	}

	public static void dispatchCards(CardDecks cat, ArrayList<Players> playerList) //distribute the cards to each person
	{
		int cardNumber = 0;
		for (int i = 0; i < playerList.size(); i++) {
			for (int j = 0; j < playerList.get(i).cardsInHand.length; j++) {
				playerList.get(i).cardsInHand[j] = cat.cardsDeck[cardNumber];
				cardNumber++;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of players:");
		int player = sc.nextInt();

		String pName;
		System.out.println("Enter Names of Players:");
		for (int i = 0; i < player; i++) {
			pName = sc.next();
			playerList.add(new Players(pName));
		}

		CardDecks cat = new CardDecks();
		fillDeck(cat);

		System.out.println("All Cards:\n" + Arrays.toString(cat.cardsDeck));
		System.out.println("--------------------------------------------------------");
		
		shuffleDeck(cat);
		System.out.println("After Shuffling Cards:\n" + Arrays.toString(cat.cardsDeck));
		System.out.println("---------------------------------------------------------");

		dispatchCards(cat, playerList);
		System.out.println("Dustribute cards to players:");

		for (Players p : playerList) {
			System.out.println(Arrays.toString(p.cardsInHand));
		
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("\nSelect Your Rule:");
		System.out.println("\n A.Normal Rule \n B.Highest Card is Joker \n C.Lowest Card as Joker \n D.Any Card is Joker");
		Character ch = sc.next().charAt(0);
		char choice = Character.toUpperCase(ch);

		switch (choice) {
		case 'A': {
			System.out.println("In Normal Rule");
			normalRule(playerList);
			break;
		}
		case 'B': {
			System.out.println("Not defined");
			break;
		}
		case 'C': {
			System.out.println("Not defined");
			break;
		}
		case 'D': {
			System.out.println("Not defined");
			break;
		}
		default: {
				System.out.println("exit");
				System.exit(choice);
		}
		}
	}

	public static void normalRule(ArrayList<Players> players) {
		int count = 0;
		for (Players p : players) {
		if(isSameRank(p.cardsInHand)) {
			p.marks=p.marks+1;
			}else if(isSameColor(p.cardsInHand)) {
				p.marks=p.marks+4;
				System.out.println("isSame:"+p.marks);
		}else {
				p.marks=0;
			}
		
			count += 1;
			p.pName = "Player".concat(String.valueOf(count));
			System.out.println(p.pName);
			p.marks = isHighestCard(p.cardsInHand);

			playerScore.add(p.marks);
			System.out.println("Marks of player:" + p.marks);
		}
		displayWinner(playerList);
	}

	public static boolean isSameRank(Card cardsInHand[])//check the player having same rank of cards check the equality of other cards with the first card
	{
		Rank firstCardRank = cardsInHand[0].rank();
		for (int i = 1; i < cardsInHand.length; i++) 
		{
			if (!firstCardRank.equals(cardsInHand[i].rank())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSameColor(Card cardsInHand[]) //check the card having same colour or not
	{
		Suit firstCardSuit = cardsInHand[0].suit();
		for (int i = 1; i < cardsInHand.length; i++) {
			if (!firstCardSuit.equals("CLUBS") || !firstCardSuit.equals("SPADES")) {
				return true;
			}
		}
		return false;
	}

	public static int isHighestCard(Card cardsInHand[])//calculate sum of cards having each player
	{
		int sum = 0;
		for (int i = 0; i < cardsInHand.length; i++) {
//			System.out.println(cardsInHand[i].rank().val);
			sum += cardsInHand[i].rank().val;
		}
		return sum;
	}

	public static void displayWinner(ArrayList<Players> playerList) //to display winner having maximum count of sum
	{
		int max = 0;
		String player = "";
		for (Players pl : playerList) {
			System.out.println("pl : " + pl.marks);
			if (pl.marks > max) {
				max = pl.marks;
				player = pl.pName;
			}
		}
		System.out.println("Winner is : " + player + " with score " + max);
	}

}
