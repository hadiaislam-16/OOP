public class Depot{
	private Rack[] racks;
	private String name;
	private int preCount;
	private int count;
	
	public Depot(String name,int preCount){
		this.name=name;
		this.count=0;
		this.preCount=preCount;
		this.racks=new Rack[preCount];
	}
	
	public void addRack(Rack r){
		if(count==racks.length){
			growCapacity();
		}
		racks[count++]=r;
	}
	
	public void growCapacity(){
		int newSize=(racks.length==0)?1:(racks.length*2);
		Rack[] r=new Rack[newSize];
		for(int i=0;i<racks.length;i++){
			r[i]=racks[i];
		}
		racks=r;
	}
	
	public Rack getRack(String id){
		for(int i=0;i<count;i++){
			if(racks[i]!=null && racks[i].getRackId().equals(id)){
				return racks[i];
			}
		}
		return null;
	}
	
	public Rack getRackFromSlotId(String id) {
        return (count > 0) ? racks[0] : null;
    }
	
	public boolean store(String id,Parcel p){
		Rack r= getRackFromSlotId(id);
		return r!=null && r.store(id,p);
	}
	
	/*public boolean remove(String id,Parcel p){
		Rack r=getRack(id);
		return r!=null && r.remove(p);
	}
	*/
	
	public Parcel remove(String id,Parcel p){
		Rack r= getRackFromSlotId(id);
		if(r!=null){
			return r.remove(id,p);
		}
		return null;
	}
	
	public String findFirstEmptySlot(){
		for(int i=0;i<count;i++){
			Rack r=racks[i];
			
			Slot[][] slots=r.getSlots2D();
			for(int j=0;j<r.getSlots2D().length;j++){
				for(int k=0;k<r.getSlots2D()[j].length;k++){
					if(slots[j][k] != null && slots[j][k].isEmpty()){
						return " "+ slots[j][k].getId();
					}
				}
			}
		}
		return "No empty Slot";
	}
	
	public int[] getTotals(){
		int total=0;
		int occupied=0;
		for(int i=0;i<count;i++){
			Rack r=racks[i];
			
			Slot[][] slots=r.getSlots2D();
			for(int j=0;j<r.getSlots2D().length;j++){
				for(int k=0;k<r.getSlots2D()[j].length;k++){
					if (racks[i] != null) {
						total++;
						if(!slots[j][k].isEmpty()){
							occupied++;
						}
					}
				}
			}
		}
		
		int[] t=new int[2];
		t[0]=total;
		t[1]=occupied;
		return t;
	}
	
	public void printAllLayouts(){
		System.out.printf("=== Depot: %s ===%n", name);

		int totalCapacity = 0;
		int totalOccupied = 0;

		for (int i = 0; i < count; i++) {
			Rack r = racks[i];
			if (r == null) continue;

			System.out.printf("Rack %s layout:%n", r.getRackId());
			System.out.print(r.printLayout());

			int[] rackTotals = r.getTotals();
			totalCapacity += rackTotals[0];
			totalOccupied += rackTotals[1];
		}

		System.out.printf("Capacity=%d, Occupied=%d%n", totalCapacity, totalOccupied);
		System.out.printf("Totals for %s: Capacity=%d, Occupied=%d%n%n", name, totalCapacity, totalOccupied);
		}
}
