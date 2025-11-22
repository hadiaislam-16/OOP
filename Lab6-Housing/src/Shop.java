public class Shop{
	private String id;
	private double price;
	private boolean available;
	private PlotType type=PlotType.COMM_SHOP;
	
	public Shop(String id){
		this.id=id;
		this.price=getPrice();
		this.available=true;
		this.type=type;
	}
	
	public boolean rentShop(){
		if(available){
			available=false;
			return true;
		}
		return false;
	}
	
	public boolean cancelShop(){
		if(!available){
			available=true;
			return true;
		}
		return false;
	}
	
	public String getId(){return id;}
	public double getPrice(){return type.getPrice();}
	public boolean getAvailable(){return available;}
	
	@Override
	public String toString(){
		return String.format("Id:%s\nPrice:%.2f PKR\nAvailable:%s",id,price,(available)?"O":"X");
	}
}
