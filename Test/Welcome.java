// Welcome.java 
public class Welcome { 
	private int x; 
	private static int n = 0; //Line 5
	
	public Welcome(String s){ 
		this(); 
		System.out.println(s); 
		System.out.println("this"); 
		++n; 
	} 
	public Welcome(){ 
		String p = "Testing"; 
		System.out.println("Set to be: " + p); 
		++n; 
	} 
	public Welcome(int x) { 
		this("Welcome to SEHH2242 OOP"); 
		System.out.printf("Output : %d\n",x);
	} 
	public static int getN() { 
		return n; 
	}
} 