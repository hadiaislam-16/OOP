public class Parcel{
	private String trackingCode;
	private Type type;
	private Status status;
	
	public Parcel(String trackingCode,Type type){
		this.trackingCode=trackingCode;
		this.type=type;
		this.status=Status.IN_STORAGE;
	}
	
	public String getCode(){return this.trackingCode;}
	public Type getType(){return this.type;}
	public Status getStatus(){return this.status;}
	
	public void setCode(String trackingCode){this.trackingCode=trackingCode;}
	public void setType(Type type){this.type=type;}
	public void setStatus(Status status){this.status=status;}
	
	public String toString(){
		return String.format("%s | %s | %s", trackingCode,
                (type == Type.FRAGILE ? "Fragile" : "Regular"),
                (status == Status.IN_STORAGE ? "In Storage" : "Out for Delivery"));
	}
}