public class Plot{
	private String id;
	//private int row;
	//private int col;
	private PlotType type;
	private ShapeType shape;
	private boolean available;
	private double area;
	
	private double width;
	private double depth;
	private double front;
	private double back;
	private double width1;
	private double width2;
	private double depth1;
	private double depth2;
	
	public Plot(String id,PlotType type,double width,double depth){
		this.id=id;
		this.type=type;
		this.shape=	ShapeType.RECTANGLE;
		this.available=true;
		this.width=width;
		this.depth=depth;
		this.area=width*depth;
	}
	
	public Plot(String id,PlotType type,double front,double back,double depth){
		this.id=id;
		this.type=type;
		this.shape=ShapeType.TRAPEZOID;
		this.available=true;
		this.front=front;
		this.back=back;
		this.depth=depth;
		this.area=((front+back)/2)*depth;
	}
	
	public Plot(String id,PlotType type,double width1,double depth1,double width2,double depth2){
		this.id=id;
		this.type=type;
		this.shape=ShapeType.L_SHAPE;
		this.available=true;
		this.width1=width1;
		this.depth1=depth1;
		this.width2=width2;
		this.depth2=depth2;
		this.area=(width1*depth1)+(width2*depth2);
	}
	
	public boolean bookPlot(){
		if(available){
			available=false;
			return true;
		}
		return false;
	}
	
	public boolean cancelPlot(){
		if(!available){
			available=true;
			return true;
		}
		return false;
	}
	
	public String getId(){return id;}
	public void setId(String id){this.id=id;}
	public PlotType getType(){return type;}
	public ShapeType getShape(){return shape;}
	public double getArea(){return area;}
	public boolean getAvailable(){return available;}
	public double getPrice(){return type.getPrice();}
	
	@Override
	public String toString(){
		return String.format("ID:%s\nType:%s\nArea:%.2f sq units\nPrice:%.2f PKR\nAvailable:%s",id,type,area,getPrice(),(available)?"O":"X");
	}
}