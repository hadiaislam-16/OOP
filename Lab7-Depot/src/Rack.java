public class Rack{
	private int[] rowLength;
	private Slot[][] slots;
	private String id;
	
	public Rack(String id,int[] rowLength){
		this.id=id;
		this.rowLength=rowLength;
		slots=new Slot[rowLength.length][];
		for(int i=0;i<rowLength.length;i++){
			slots[i]=new Slot[rowLength[i]];
			for(int j=0;j<rowLength[i];j++){
				slots[i][j]=new Slot(i+1,j+1);
			}
		}
	}
	
	public String getRackId(){return id;}
	public int[] getRowLength(){
		return rowLength;
	}
	
	public Slot getSlotById(String id){
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j]!=null && slots[i][j].getId().equals(id)){
					return slots[i][j];
				}
			}
		}
		return null;
	}
	
	public Slot[] getSlots(){
		Slot[] s=new Slot[slots.length];
		int idx=0;
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j]!=null){
					s[idx++]=slots[i][j];
				}
			}
		}
		return s;
	}
	
	public Slot[][] getSlots2D(){
		Slot[][] s=new Slot[slots.length][];
		for(int i=0;i<slots.length;i++){
			s[i]=new Slot[slots[i].length];
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j]!=null){
					s[i][j]=slots[i][j];
				}
			}
		}
		return s;
	}
	
	public Parcel[] getParcelsByType(Type type){
		int total=0;
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(!slots[i][j].isEmpty() && slots[i][j].getParcel().getType().equals(type)){
					total++;
				}
			}
		}
		
		int idx=0;
		Parcel[] p=new Parcel[total];
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(!slots[i][j].isEmpty() && slots[i][j].getParcel().getType().equals(type)){
					p[idx++]=slots[i][j].getParcel();
				}
			}
		}
		return p;
	}
	
	public boolean store(String id,Parcel p){
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j].getId().equals(id)){
					return slots[i][j]!=null && slots[i][j].store(p);
				}
			}
		}
		return false;
	}
	
	public Parcel remove(String id,Parcel p){
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j].getId().equals(id)){
					return slots[i][j].remove(p);
				}
			}
		}
		return null;
	}
	
	public String printLayout(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				sb.append(String.format("%s",slots[i][j].toString()));
			}
		}
		return sb.toString();
	}
	
	public int[] getTotals() {
    int total = 0;
    int occupied = 0;
    for (int i = 0; i < slots.length; i++) {
        for (int j = 0; j < slots[i].length; j++) {
            total++;
            if (!slots[i][j].isEmpty()) occupied++;
        }
    }
    return new int[]{total, occupied};
	}
	
	@Override
	public String toString(){
		int total=0;
		int available=0;
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				total++;
			}
		}
		
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[i].length;j++){
				if(slots[i][j].isEmpty()){
					available++;
				}
			}
		}
		
		return String.format("Total slots:%d-Available Slots:%d",total,available);
	}
}