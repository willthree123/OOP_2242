public class Classification {
    int side1, side2, side3;
    boolean Scalene, RightAngled;

    Classification(int sideA, int sideB, int sideC) {
        side1 = sideA;
        side2 = sideB;
        side3 = sideC;
    }

    void Classify() {
        if (TriangleCheck() == true) {
            if (EquilateralCheck() == false) {
                if (IsoscelesCheck() == false) {
                    ScaleneCheck();
                    RightAngledCheck();
                    Print();
                    
                }
            }
        }
    }
    void Print(){
        System.out.print("These three sides could form a ");
        if(Scalene==true && RightAngled==true){
            System.out.println("Right-angle Triangle and Scalene Triangle");
        }
        else if(Scalene==true){
            System.out.println("Scalene Triangle");
        }
        else if(RightAngled==true){
            System.out.println("Right-angle Triangle");
        }

    }
    void ScaleneCheck() {
        if ((side1 != side2) && (side1 != side2) && (side2 != side3)) {
            Scalene = true;
        } else {
            Scalene = false;
        }
    };

    void RightAngledCheck() {
        if (side1 * side1 == (side2 * side2 + side3 * side3)) {
            RightAngled = true;
        } else {
            RightAngled = false;
        }
    }

    boolean IsoscelesCheck() {
        if ((side1 == side2) || (side1 == side2) || (side2 == side3)) {
            System.out.println("These three sides could form a Isosceles Triangle");
            return true;
        } else {
            return false;
        }
    }

    boolean EquilateralCheck() {
        if ((side1 == side2) && (side2 == side3)) {
            System.out.println("These three sides could form a Equilateral Triangle.");
            return true;
        } else {
            return false;
        }
    }

    boolean TriangleCheck() {
        if (side1 >= (side2 + side3)) {
            System.out.println("These three sides could not form any triangle.");
            return false;
        } else {
            return true;
        }
    }

    void Sort() {
        int temp;
        if (side1 < side2) {
            temp = side1;
            side1 = side2;
            side2 = temp;
        }
        if (side1 < side3) {
            temp = side1;
            side1 = side3;
            side3 = temp;
        }
        if (side2 < side3) {
            temp = side2;
            side2 = side3;
            side3 = temp;
        }
    }

}
