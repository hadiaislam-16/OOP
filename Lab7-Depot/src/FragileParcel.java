public class FragileParcel extends Parcel{
	private boolean insuranceFlag;
	
	public FragileParcel(String id,Type type,boolean insuranceFlag){
		super(id,type);
		this.insuranceFlag=true;
	}
	
	public boolean getFlag(){return insuranceFlag;}
	public void setFlag(boolean insuranceFlag){this.insuranceFlag=insuranceFlag;}
	
	public String toString(){
		return String.format("%s Insurance Flag:%s",super.toString(),(insuranceFlag)?"O":"X");
	}
}