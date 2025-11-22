public class Demo{
	public static void main(String[] args){
		Game g1=new Game(4,13);
		g1.initialize();
		g1.deal();
		g1.playAll();
		System.out.println(g1.determineWinner());
		System.out.println(g1);
		System.out.println("----------------");
	    Game g2=new Game(6,8);
		g2.initialize();
		g2.deal();
		g2.playAll();
		System.out.println(g2.determineWinner());
		System.out.println(g2);
	}
}