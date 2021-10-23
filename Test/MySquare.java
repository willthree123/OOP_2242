public class MySquare extends MyRectangle { 
    public MySquare(int length) { 
        super(length, length);
    }
    public String getMyArea() {
     return ("Square Area = "+ getWidth() * getWidth());
    }
} 