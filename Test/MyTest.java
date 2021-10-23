
public class MyTest { 
    public static void main(String[] args) { 
        MySquare s1 = new MySquare(8); 
        MyRectangle t1 = new MyRectangle(10);
        MyRectangle t2 = new MyRectangle(); 
        t2 = s1; 
        System.out.println(s1.getMyArea()); 
        System.out.println(t1.getMyArea()); 
        System.out.println(t2.getMyArea()); 
    } 
} 

