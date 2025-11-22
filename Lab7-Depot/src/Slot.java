public class Slot{
	private String id;
	private int row;
	private int col;
	private boolean isEmpty;
	private Parcel parcel;
	
	public Slot(int row,int col){
		this.row=row;
		this.col=col;
		this.id=String.format("R%d-S%02d",row,col);
		this.isEmpty=true;
	}
	
	public boolean store(Parcel p){
		if(isEmpty){
			isEmpty=false;
			 parcel = p;
			p.setStatus(Status.IN_STORAGE);
			return true;
		}
		return false;
	}
	
	public Parcel remove(Parcel p){
		if(parcel != null && parcel.equals(p)){
			isEmpty=true;
			parcel.setStatus(Status.OUT_FOR_DELIVERY);
			Parcel temp = parcel;
            parcel = null;
            return temp;
		}
		return null;
	}
	
	public String getId(){return this.id;}
	public boolean isEmpty(){return isEmpty;}
	public Parcel getParcel(){return parcel;}
	
	@Override
	public String toString(){
		if(isEmpty){
			return "[--]";
		}
		return String.format("%s",(parcel.getType()==Type.REGULAR)?"R":"[F]");
	}
}