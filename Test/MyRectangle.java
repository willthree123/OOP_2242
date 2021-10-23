public class MyRectangle {
    private int width, height;
        public MyRectangle(int x, int y){
            width=x;
            height=y;
    }
    public MyRectangle() {
        this(4, 4);
    }
    public MyRectangle(int x) { 
        this(x, 4); 
    }
    public int getWidth() { 
        return width;
    }
    public int getHeight() { 
        return height; 
    }
    public String getMyArea() {
        return ("Rectangle Area = " + (width * height)); 
    }
} 