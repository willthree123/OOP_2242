
import java.util.Scanner;

import javax.print.event.PrintEvent;

public class Test {
    static int int_a, int_b, int_c; 
    static boolean bool_a, bool_b, bool_c;
    static double double_a, double_b, double_c;
    static float float_a, float_b, float_c;
    static char char_a, char_b, char_c;
    static String string_a, string_b, string_c;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) {

        Welcome(); 

        Main();

        End(); 
    }

    public static void Main() { // User input validation
        Scanner input = new Scanner(System.in);
        
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Welcome() { // Print out instruction message
        System.out.print("\033[H\033[2J"); // Clear the console
        System.out.flush(); // Clear the console
        System.out.println("==== Before values ====");
        System.out.println("");
        System.out.printf("  bool: a="+bool_a+" b="+bool_b+ " c="+bool_c+"\n");
        System.out.printf("   int: a="+int_a+" b="+int_b+ " c="+int_c+"\n");
        System.out.printf(" float: a="+float_a+" b="+float_b+ " c="+float_c+"\n");
        System.out.printf("double: a="+double_a+" b="+double_b+ " c="+double_c+"\n");
        System.out.printf("  char: a="+char_a+" b="+char_b+ " c="+char_c+"\n");
        System.out.printf("string: a="+string_a+" b="+string_b+ " c="+string_c+"\n");
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");
    }
    public static void End(){
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");
        System.out.printf("  bool: a="+bool_a+" b="+bool_b+ " c="+bool_c+"\n");
        System.out.printf("   int: a="+int_a+" b="+int_b+ " c="+int_c+"\n");
        System.out.printf(" float: a="+float_a+" b="+float_b+ " c="+float_c+"\n");
        System.out.printf("double: a="+double_a+" b="+double_b+ " c="+double_c+"\n");
        System.out.printf("  char: a="+char_a+" b="+char_b+ " c="+char_c+"\n");
        System.out.printf("string: a="+string_a+" b="+string_b+ " c="+string_c+"\n");
        System.out.println("");
        System.out.println(""); // Console spacing
    }
}