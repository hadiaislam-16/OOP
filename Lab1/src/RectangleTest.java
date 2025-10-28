public class RectangleTest {
    public static void main(String[] args) {
        
        Rectangle rect1 = new Rectangle(12, 8);
        

        System.out.println("Length = " + rect1.length);
        System.out.println("Width = " + rect1.width);
        System.out.println("Area = " + rect1.area());
        System.out.println("Perimeter = " + rect1.perimeter());
    }
}