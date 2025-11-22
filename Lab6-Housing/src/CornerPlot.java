public class CornerPlot extends Plot{
	private double w2;
	
	public CornerPlot(String id,PlotType type,double width,double depth,double w2){
		super(id,type,width,depth);
		this.w2=w2;
	}
	
	public CornerPlot(String id,PlotType type,double width1,double depth1,double width2,double depth2,double w2){
		super(id,type,width1,depth1,width2,depth2);
		this.w2=w2;
	}
	
	public CornerPlot(String id,PlotType type,double front,double back,double depth,double w2){
		super(id,type,front,back,depth);
		this.w2=w2;
	}
	
	public double getw2(){return w2;}
	
	public String toString(){
		return String.format("%s",super.toString());
	}
	
	@Override
	public double getPrice(){
		double price=((1+0.08)*super.getPrice());
		return price;
	}
}