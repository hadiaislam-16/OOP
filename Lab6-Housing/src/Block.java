import java.util.Random;
public class Block{
	private String name;
	private ShapeType shape;
	private PlotType type;
	private Plot[][] plots;
	private int[] rowLength=new int[]{10, 11, 12, 13, 14};
	private Park[] parks;
	private int p_num;
	private Market market;
	
	public Block(String name){
		this.name=name;
		plots=new Plot[rowLength.length][];
		for(int i=0;i<plots.length;i++){
			plots[i]=new Plot[rowLength[i]];
			
			shape=ShapeType.RECTANGLE;
			
			switch(i){
				case 0: {
					type=PlotType.RES_5_MARLA;
					break;
				}
				case 1: {
					type=PlotType.RES_10_MARLA;
					break;
				}
				case 2: {
					shape=ShapeType.TRAPEZOID;
					type=PlotType.RES_1_KANAL;
					break;
				}
				case 3: {
					type=PlotType.COMM_SHOP;
					break;
				}
				case 4: {
					type=PlotType.COMM_OFFICE;
					break;
				}
				
			}
			
			double width=10;
			double front=10;
			double depth=10;
			double back=10;
			double w2=10;
			
			for(int j=0;j<rowLength[i];j++){
				if((j+1)%5==0){
					plots[i][j]=new Plot(String.format("%03d",j),PlotType.PARKING,width,depth);
				}
				else if(i<3 && ((j+1)%4==0)){
					if(shape==ShapeType.RECTANGLE){
						plots[i][j]=new CornerPlot(String.format("%03d",j),type,width,depth,w2);
					}
					else{
						plots[i][j]=new CornerPlot(String.format("%03d",j),type,front,back,depth,w2);
					}
				}
				else{
					if(shape==ShapeType.RECTANGLE){
						plots[i][j]=new Plot(String.format("%03d",j),type,width,depth);
					}
					else{
						plots[i][j]=new Plot(String.format("%03d",j),type,front,back,depth);
					}
				}
				
				plots[i][j].setId(String.format("%d-%03d",i+1,j+1));
			}
			
		}
		
		this.market=new Market("MM ALAM");
		Random rand=new Random();
		p_num=rand.nextInt(1,3);
		parks=new Park[p_num];
		for(int i=0;i<p_num;i++){
			double width=10;
			double depth=10;
			parks[i]=new Park("Park "+(i+1),width,depth);
		}
		
	}
	
	public String getName(){return name;}
	
	public Plot getPlot(String id){
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getId().equals(id)){
					return plots[i][j];
				}
			}
		}
		return null;
	}
	
	public boolean bookPlot(String id){
			Plot p=getPlot(id);
			if(p!=null){
				return p!=null && p.bookPlot();
			}
			return false;
	}
	
	public boolean cancelPlot(String id){
			Plot p=getPlot(id);
			if(p!=null){
				return p!=null && p.cancelPlot();
			}
			return false;
	}
	
	public Plot[] getTotalPlots(){
		int total=0;
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null){
					total++;
				}
			}
		}
		
		int idx=0;
		Plot[] temp=new Plot[total];
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null){
					temp[idx++]=plots[i][j];
				}
			}
		}
		return temp;
	}
	
	public Plot[] getTotalPlotsByType(PlotType type){
		int total=0;
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getType().equals(type)){
					total++;
				}
			}
		}
		
		int idx=0;
		Plot[] temp=new Plot[total];
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getType().equals(type)){
					temp[idx++]=plots[i][j];
				}
			}
		}
		return temp;
	}
	
	public Plot[][] getPlots(){
		Plot[][] temp=new Plot[plots.length][];
		for(int i=0;i<plots.length;i++){
			temp[i]=new Plot[plots[i].length];
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null){
					temp[i][j]=plots[i][j];
				}
			}
		}
		return temp;
	}
	
	public Plot[] getAvailablePlots(){
		int total=0;
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getAvailable()){
					total++;
				}
			}
		}
		
		int idx=0;
		Plot[] temp=new Plot[total];
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getAvailable()){
					temp[idx++]=plots[i][j];
				}
			}
		}
		return temp;
	}
	
	public Plot[] getAvailablePlotsByType(PlotType type){
		int total=0;
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getType().equals(type) && plots[i][j].getAvailable()){
					total++;
				}
			}
		}
		
		int idx=0;
		Plot[] temp=new Plot[total];
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				if(plots[i][j]!=null && plots[i][j].getType().equals(type) && plots[i][j].getAvailable()){
					temp[idx++]=plots[i][j];
				}
			}
		}
		return temp;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(String.format("Name:%s Total Plots:%d\n",name,getTotalPlots().length));
		for(int i=0;i<plots.length;i++){
			for(int j=0;j<plots[i].length;j++){
				sb.append(plots[i][j].toString()).append("\n");
			}
		}
		sb.append(market.toString());
		for(int i=0;i<parks.length;i++){
			sb.append(parks[i].toString()).append("\n");
		}
		return sb.toString();
	}
}