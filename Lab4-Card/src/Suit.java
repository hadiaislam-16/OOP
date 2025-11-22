public enum Suit{
	SPADES("♠️"), HEARTS("❤️"), DIAMONDS("🔶"), CLUBS("♣️");
	
	private String symbol;
	
	private Suit(String symbol){
		this.symbol=symbol;
	}
	
	public String getSymbol(){return this.symbol;}
}