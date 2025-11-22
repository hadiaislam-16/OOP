public class Market{
	private Shop[] shops;
	private int length;
	private String name;
	private final int preCount=12;
	
	public Market(String name){
		this.length=0;
		this.name=name;
		shops=new Shop[preCount];
		
		for(int i=0;i<preCount;i++){
			addShop();
		}
	}
	
	public void addShop(){
		if(length==shops.length){
			growCapacity();
		}
		shops[length++]=new Shop(" "+length+1);
	}
	
	public void growCapacity(){
		int size=(shops.length==0)?1:(shops.length*2);
		Shop[] temp=new Shop[size];
		for(int i=0;i<shops.length;i++){
			temp[i]=shops[i];
		}
		shops=temp;
	}
	
	public Shop getShop(String id){
		for(int i=0;i<shops.length;i++){
			if(shops[i]!=null && shops[i].getId().equals(id)){
				return shops[i];
			}
		}
		return null;
	}
	
	public boolean rentShop(String id){
		Shop s=getShop(id);
		return (s!=null) && (s.rentShop());
	}
	
	public boolean cancelShop(String id){
		Shop s=getShop(id);
		return (s!=null) && (s.cancelShop());
	}
	
	public boolean getAvailable(){
		for(int i=0;i<shops.length;i++){
			if(shops[i]!=null && shops[i].getAvailable()){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return String.format("%s(%d) Vacant Shop:%s",name,length,(getAvailable())?"O":"X");
	}
}