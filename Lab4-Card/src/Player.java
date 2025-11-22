public class Player{
	private String name;
	private Card[] hand;
	private int preCapacity;
	private int size;
	
	public Player(String name,int preCapacity){
		this.name=name;
		this.preCapacity=preCapacity;
		this.hand=new Card[preCapacity];
		this.size = 0; 
	}
	
	public boolean isOut(){
		if(hand==null || hand.length==0){
			return true;
		}
		return false;
	}
	
	public Card addCard(Card c) {
        if (size < preCapacity) {
            hand[size++] = c;
            return c;
        } else {
            System.out.println("Hand is full!");
            return null;
        }
    }
	
	public String getName(){ return this.name;}
	public void setName(String name){ this.name=name;}
	
	public int calculateScore(){
		int count=0;
		for(int i=0;i<size;i++){
			count+=hand[i].getRank().getValue();
		}
		return count;
	}
	
	public Card playCard(){
		Card[] temp=new Card[hand.length-1];
		Card x=hand[0];
		for(int i=1;i<hand.length;i++){
			temp[i-1]=hand[i];
		}
		hand=temp;
		return x;
	}
	
	public String showHand(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<size;i++){
			sb.append(hand[i]).append(" ");
		}
		return sb.toString();
	}
	
	public String toString(){
		return String.format("Player %s (%d cards)",name,hand.length);
	}
}