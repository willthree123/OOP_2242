
public class TriangleChecker_20190875A {
    public static void main(String args[]) {
        Sides side1 = new Sides();
        Sides side2 = new Sides();
        Sides side3 = new Sides();

        InstructionPrint();
        System.out.print("Please enter the first side of the triangle  : ");
        side1.userinput();
        System.out.print("Please enter the second side of the triangle : ");
        side2.userinput();
        System.out.print("Please enter the third side of the triangle  : ");
        side3.userinput();

        Classification Triangle1 = new Classification(side1.value, side2.value, side3.value); //
        Triangle1.Sort(); // Sort the three inputs, descending order
        
        System.out.printf("%S %n","\n -- Result --");
        System.out.println("First Side : " + side1.value);
        System.out.println("Second Side: " + side2.value);
        System.out.println("Third Side : " + side3.value);
        System.out.println("");

        Triangle1.Classify();

        System.out.println(""); //Console spacing
    }

    public static void InstructionPrint() {
        System.out.print("\033[H\033[2J"); // Clear the console
        System.out.flush(); // Clear the console

        System.out.printf("%S %n","==========TRAIANGLE CHECKER=========="); // Print out message
        System.out.println("");
        System.out.println("         -- How to use --");
        System.out.printf("1. ONLY integer values are accepted.%n2. Type the three inputs one by one.%n");
        System.out.println("");
    }
}