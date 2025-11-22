import java.util.Random;
public class Deck{
	Card[] cards;
	
	public Deck(){
		this.cards=new Card[52];
		Suit[] suits=Suit.values();
		Rank[] ranks=Rank.values();
		int counter=0;
		
		for(int i=0;i<suits.length;i++){
			for(int j=0;j<ranks.length;j++){
				cards[counter++]=new Card(suits[i],ranks[j]);
			}
		}
	}
	
	public void shuffle(){
		Random rand=new Random();
		for(int i=0;i<52;i++){
			int idx=rand.nextInt(i,52);
			Card temp=cards[i];
			cards[i]=cards[idx];
			cards[idx]=temp;
		}
		
	}
	
	public Card draw(){
		Random rand=new Random();
		int idx=rand.nextInt(0,52);
		Card temp=cards[idx];
		return temp;
	}
	
	public Card[] drawCards(int n){
		Card[] drawn=new Card[n];
		for(int i=0;i<n;i++){
			drawn[i]=draw();
		}
		return drawn;
	}
	
	public boolean isEmpty(){
		if(cards==null || cards.length==0){
			return true;
		}
		return false;
	}
	
	public int getSize(){return cards.length;}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<getSize();i++){
			sb.append(cards[i]).append("\n");
		}
		return sb.toString();
	}
}
