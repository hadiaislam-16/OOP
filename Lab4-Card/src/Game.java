public class Game{
	private int numberOfPlayers;
	private int numberOfCards;
	private Player[] players;
	private Deck deck;
	private int[] scoreBoard;
	private int counterRound;
	
	
	public Game(int numberOfPlayers,int numberOfCards){
		this.numberOfPlayers=numberOfPlayers;
		this.numberOfCards=numberOfCards;
		this.scoreBoard=new int[numberOfPlayers];
		this.players=new Player[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++){
			players[i]=new Player(("Player "+(i+1)),numberOfCards);
			scoreBoard[i]=0;
		}
		this.counterRound=1;
	}
	
	public void initialize(){
		deck=new Deck();
		deck.shuffle();
		counterRound=1;
	}
	
	public void deal(){
		if((numberOfCards*numberOfPlayers)<=52){
			for(int i=0;i<numberOfCards;i++){
				for(int j=0;j<numberOfPlayers;j++){
					players[j].addCard(deck.draw());
				}
			}
		}
		else{
			System.out.println("Number of Cards per player are a lot.");
		}
	}
	
	public void playCard(){
		Card[] cards=new Card[players.length];
		int score=0;
		int idx=-1;
		for(int i=0;i<numberOfPlayers;i++){
			cards[i]=players[i].playCard();
		}
		
		for(int i=0;i<cards.length;i++){
			int temp=cards[i].getRank().getValue();
			if(score<temp){
				score=temp;
				idx=i;
			}
			else if(score==temp){
				scoreBoard[i]=0;
			}
		}
		if(idx!=-1){
			scoreBoard[idx]+=1;
		}
	}
	
	public void playAll(){
		for(int i=0;i<numberOfCards;i++){
			counterRound++;
			playCard();
		}
	}
	
	public String determineWinner(){
		int score=0;
		int idx=0;
		for(int i=0;i<scoreBoard.length;i++){
			int temp=scoreBoard[i];
			if(score<temp){
				score=temp;
				idx=i;
			}
		}
		return String.format("Player %d has won the game with a score of %d",idx+1,score);
	}
	
	public int getCurrentRound(){return this.counterRound;}
	
	public boolean isOver(){
		if(counterRound==numberOfCards){
			return true;
		}
		return false;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<scoreBoard.length;i++){
			sb.append("Player ").append(i+1).append("'s score: ").append(scoreBoard[i]).append("\n");
		}
		return sb.toString();
	}

}