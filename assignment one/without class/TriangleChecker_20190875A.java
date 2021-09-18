
/*
SEHH2242 OBJECT ORIENTED PROGRAMMING Assignment One
Stundent Name  		  Student Number Tutorial Group
KOK Siu Chung   		20190875A        101C

2021/9/17
*/
import java.util.Scanner;

public class TriangleChecker_20190875A {
    static int side1, side2, side3; // User inputs

    public static void main(String args[]) {

        InstructionPrint(); // Print Instruction Message

        System.out.print("Please enter the first side of the triangle  : "); // Prompt for input
        side1 = userinput(); // user input side1
        System.out.print("Please enter the second side of the triangle : "); // Prompt for input
        side2 = userinput(); // user input side2
        System.out.print("Please enter the third side of the triangle  : "); // Prompt for input
        side3 = userinput(); // user input side3

        Sort(); // Sort the three inputs, descending order

        // Display Result
        System.out.printf("%S %n", "\n -- Result --"); 
        System.out.printf("Sides (descending order): %d %d %d%n", side1, side2, side3);

        Classify(); // Classify the triangle

        System.out.println(""); // Console spacing
    }

    public static void InstructionPrint() { // Print out instruction message
        System.out.print("\033[H\033[2J"); // Clear the console
        System.out.flush(); // Clear the console

        // Print out message
        System.out.printf("%S %n", "==========TRAIANGLE CHECKER==========");
        System.out.println("");
        System.out.println("         -- How to use --");
        System.out.printf("1. ONLY integer values are accepted.%n2. Type the three inputs one by one.%n");
        System.out.println("");
    }

    public static int userinput() { // User input validation
        while (true) { // While the input is not positive integer
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) { // Check the input to see it is int or not
                int temp = input.nextInt(); // Save the int input to a temporary variable
                if (temp > 0) { // Check the input to see it is positive integer value or not
                    return temp; // Return the value
                } else { // The input is non-positive integer
                    System.out.print("Please a positive integer value: "); // Prompt for input
                }
            } else { // The input is not integer
                System.out.print("Please a positive integer value: "); // Prompt for input
            }
        }
    }

    public static void Classify() { // Classify the triangle
        if (TriangleCheck() == true) { // Check whether can these three sides can form a triangle
            if (EquilateralCheck() == false) { // Check whether the triangle is equilateral
                if (IsoscelesCheck() == false) { // Check whether the triangle is isosceles
                    RightAngledCheck(); // Check whether the triangle is right-angled
                }
            }
        }
    }

    public static void RightAngledCheck() { // Check whether the triangle is right-angled
        if (side1 * side1 == (side2 * side2 + side3 * side3)) { // Determine whether the triangle is right-angled
            System.out.println("These three sides could form a Right-angled Triangle and Scalene Triangle."); // The triangle is Right-angled and Scalene
        } else { // The triangle is not right-angled
            System.out.println("These three sides could form a Scalene Triangle."); // The triangle is Scalene
            
        }
    }

    public static boolean IsoscelesCheck() { // Check whether the triangle is isosceles
        if ((side1 == side2) || (side1 == side2) || (side2 == side3)) { // Determine whether the triangle is isosceles
            System.out.println("These three sides could form a Isosceles Triangle.");// The triangle is isosceles
            return true;
        } else { // The triangle is not isosceles
            return false;
        }
    }

    public static boolean EquilateralCheck() { // Check whether the triangle is equilateral
        if ((side1 == side2) && (side2 == side3)) { // Determine whether the triangle is equilateral
            System.out.println("These three sides could form a Equilateral Triangle.");// The triangle is equilateral
            return true;
        } else { // The triangle is not equilateral
            return false;
        }
    }

    public static boolean TriangleCheck() { // Check whether can these three sides can form a triangle
        if (side1 >= (side2 + side3)) { // Determine whether can these three sides can form a triangle
            System.out.println("These three sides could not form any triangle."); // These three sides can form a triangle
            return false;
        } else { // These three sides can not form a triangle
            return true;
        }
    }

    public static void Sort() { // Sort the three inputs, descending order
        int temp; // Temporary variable

        // Determine whether side1 or side2 is larger
        if (side1 < side2) {
            temp = side1;
            side1 = side2;
            side2 = temp;
        }

        // Determine whether side1 or side3 is larger
        if (side1 < side3) {
            temp = side1;
            side1 = side3;
            side3 = temp;
        }

        // Determine whether side2 or side3 is larger
        if (side2 < side3) {
            temp = side2;
            side2 = side3;
            side3 = temp;
        }
    }
}