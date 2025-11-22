public class CitySociety{
	private String name;
	private int preCount;
	private int count;
	private Society[] societies;
	
	public CitySociety(String name,int preCount){
		this.name=name;
		this.count=0;
		this.preCount=preCount;
		societies=new Society[preCount];
		
		for(int i=0;i<preCount;i++){
			addSociety();
		}
	}
	
	public void addSociety(){
		if(count==societies.length){
			growCapacity();
		}
		societies[count++]=new Society("LDA "+(count+1),5);
	}
	
	public void growCapacity(){
		int newCount=(societies.length==0)?1:(societies.length*2);
		Society[] temp=new Society[newCount];
		for(int i=0;i<societies.length;i++){
			temp[i]=societies[i];
		}
		societies=temp;
	}
	
	public Society getSociety(String name){
		for(int i=0;i<societies.length;i++){
			if(societies[i]!=null && societies[i].getName().equals(name)){
				return societies[i];
			}
		}
		return null;
	}
	
	public void removeSociety(String name){
		int idx=0;
		Society s=getSociety(name);
		Society[] temp= new Society[count-1];
		for(int i=0;i<societies.length;i++){
			if(societies[i]!=s){
				temp[idx++]=societies[i];
			}
		}
		societies=temp;
	}
	
	public boolean bookPlot(String name,int idx,String id){
		Society s=getSociety(name);
			if(s!=null){
				return s.bookPlot(idx,id);
			}
			return false;
	}
	
	public boolean cancelPlot(String name,int idx,String id){
		Society s=getSociety(name);
			if(s!=null){
				return s.cancelPlot(idx,id);
			}
			return false;
	}
	
	public String firstAvailable1KanalPlot(){
		for(int i=0;i<societies.length;i++){
			Society s=societies[i];
			for(int j=0;j<s.getBlocks().length;j++){
				Block b=s.getBlocks()[j];
				Plot[] plots=b.getTotalPlots();
				for(int k=0;k<plots.length;k++){
					Plot p=plots[k];
					if(p!=null && p.getType()==PlotType.RES_1_KANAL && p.getAvailable()){
						return String.format("%s > %s > Plot %s (%s, area %.2f su, %.2f PKR)",
                            s.getName(),
                            b.getName(),
                            p.getId(),
                            p.getType(),
                            p.getArea(),
                            p.getPrice());
					}
				}
			}
		}
		return "No available RES_1_KANAL found";
	}
	
	public String firstAvailableCommShop(){
		for(int i=0;i<societies.length;i++){
			Society s=societies[i];
			for(int j=0;j<s.getBlocks().length;j++){
				Block b=s.getBlocks()[j];
				
				Plot[][] plots=b.getPlots();
				for(int l=0;l<plots.length;l++){
					if(l==3){
						for(int k=0;k<plots[l].length;k++){
							Plot p=plots[l][k];
							if(p!=null && p.getType()==PlotType.COMM_SHOP && p.getAvailable()){
								return String.format("%s > %s > Plot %s (%s, area %.2f su, %.2f PKR)",
									s.getName(),
									b.getName(),
									p.getId(),
									p.getType(),
									p.getArea(),
									p.getPrice());
							}
						}
				}
				}
			}
		}
		return "No available COMM SHOP found";
	}
	
	public String firstLargestAvailablePlot(){
		Plot largest = null;
		Society bestSociety = null;
		Block bestBlock = null;
		for(int i=0;i<societies.length;i++){
			Society s=societies[i];
			for(int j=0;j<s.getBlocks().length;j++){
				Block b=s.getBlocks()[j];
				
				Plot[][] plots=b.getPlots();
				for(int l=0;l<3;l++){
						for(int k=0;k<plots[l].length;k++){
							Plot p=plots[l][k];
							if(p!=null && p.getAvailable()){
								if(largest == null || p.getArea() > largest.getArea()){
									largest = p;
									bestSociety = s;
									bestBlock = b;
								}
							}
						}
				}
			}
		}
		if (largest != null) {
        return String.format(
            "Largest available residential plot: %s > %s > Plot %s (%.2f su, %.2f PKR)",
            bestSociety.getName(),
            bestBlock.getName(),
            largest.getId(),
            largest.getArea(),
            largest.getPrice()
        );
		}
		return "Not available";
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
			sb.append(String.format("City:%s\n",name));
			for(int i=0;i<societies.length;i++){
				sb.append(String.format("%s\n",societies[i].toString()));
			}
			return sb.toString();
	}
}