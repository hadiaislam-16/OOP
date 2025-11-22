public class Park{
	private String name;
	private ShapeType shape;
	private double area;
	private double width;
	private double depth;
	
	public Park(String name,double width,double depth){
		this.shape=ShapeType.RECTANGLE;
		this.name=name;
		this.width=width;
		this.depth=depth;
		this.area=getArea();
	}
	
	public String getName(){return name;}
	public ShapeType getShape(){return shape;}
	public double getArea(){return (width*depth);}
	
	public String toString(){
		return String.format("%s-%.2f sq units",name,area);
	}
}