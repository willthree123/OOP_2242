import java.util.Scanner;

public class Sides {
    int value;

    void userinput() {
        boolean finished = false;
        while (finished == false) {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) { // Check the input to see it is int or not
                int input_temp = input.nextInt(); // Save the int input to a temp value
                if (input_temp > 0) { // Check the input to see it is positive integer value or not
                    value = input_temp; // Save the value to sides[]
                    finished = true;
                } else {// The input is non-positive integer
                    System.out.print("Please a positive integer value: ");
                }
            } else {// The input is not integer
                System.out.print("Please a positive integer value: ");
            }
        }
    }
}
