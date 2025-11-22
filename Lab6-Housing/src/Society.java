public class Society{
		private String name;
		private Block[] blocks;
		private int preCount;
		private int size;
		String[] alpha=new String[]{"A","B","C","D","E","F","G","H","I"};
		
		public Society(String name,int preCount){
			this.name=name;
			this.size=0;
			blocks=new Block[preCount];
			for(int i=0;i<preCount;i++){
				addBlock();
			}
		}
		
		public String getName(){return name;}
		
		public void addBlock(){
			if(size==blocks.length){
				growCapacity();
			}
			blocks[size++]=new Block("Block "+alpha[size-1]);
		}
		
		public void growCapacity(){
			int newSize=(blocks.length==0)?1:(blocks.length);
			Block[] temp=new Block[newSize];
			for(int i=0;i<blocks.length;i++){
				temp[i]=blocks[i];
			}
			blocks=temp;
		}
		
		public Block getBlock(int idx){	
			if(idx>blocks.length || idx<0){       
				return null;
			}
			return blocks[idx-1];
		}
		
		public Block[] getBlocks(){	
			Block[] temp=new Block[blocks.length];
			for(int i=0;i<blocks.length;i++){
				if(blocks[i]!=null){
					temp[i]=blocks[i];
				}
			}
			return temp;
		}
		
		public Block getBlockByName(String name){	
			for(int i=0;i<blocks.length;i++){
				if(blocks[i]!=null && blocks[i].getName().equals(name)){
					return blocks[i];
				}
			}
			return null;
		}
		
		public boolean bookPlot(int idx,String id){
			Block b=getBlock(idx);
			if(b!=null){
				return b.bookPlot(id);
			}
			return false;
		}
		
		public boolean cancelPlot(int idx,String id){
			Block b=getBlock(idx);
			if(b!=null){
				return b.cancelPlot(id);
			}
			return false;
		}
		
		public int getTotalPlots(){
			int total=0;
			for(int i=0;i<blocks.length;i++){
				total+=blocks[i].getTotalPlots().length;
			}
			return total;
		}
		
		public int getTotalPlotsByType(PlotType type){
			int total=0;
			for(int i=0;i<blocks.length;i++){
				total+=blocks[i].getTotalPlotsByType(type).length;
			}
			return total;
		}
		
		public int getAvailablePlots(){
			int total=0;
			for(int i=0;i<blocks.length;i++){
				total+=blocks[i].getAvailablePlots().length;
			}
			return total;
		}
		
		public int getAvailablePlotsByType(PlotType type){
			int total=0;
			for(int i=0;i<blocks.length;i++){
				total+=blocks[i].getAvailablePlotsByType(type).length;
			}
			return total;
		}
		
		@Override	
		public String toString(){
			StringBuilder sb=new StringBuilder();
			sb.append(String.format("Society Name:%s\n",name));
			for(int i=0;i<blocks.length;i++){
				sb.append(blocks[i]).append("\n");
			}
			return sb.toString();
		}
		
}