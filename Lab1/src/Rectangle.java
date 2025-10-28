public class Rectangle {
    int length;
    int width;

    Rectangle(int l, int w) {
        length = l;
        width = w;
    }

   
    int area() {
        return length * width;
    }

    
    int perimeter() {
        return 2 * (length + width);
    }
}

