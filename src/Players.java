import java.util.Arrays;

public class Players {
	String pName;
	Card[] cardsInHand=new Card[3];//getting card in per person hand
	int marks=0;
	
	public Players(String pName) {
		this.pName=pName;
	}

	@Override
	public String toString() {
		return "Players [pName=" + pName + ", cardsInHand=" + Arrays.toString(cardsInHand) + ", Marks=" + marks + "]";
	}

	
}
