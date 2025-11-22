public class Card{
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit,Rank rank){
		this.suit=suit;
		this.rank=rank;
	}
	
	public Suit getSuit(){return this.suit;}
	public Rank getRank(){return this.rank;}
	
	public String toString(){
		return String.format("%s of %s",rank,suit);
	}
}