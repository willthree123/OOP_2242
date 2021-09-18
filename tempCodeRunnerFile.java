public static void RightAngledCheck() { // Check whether the triangle is right-angled
    if (side1 * side1 == (side2 * side2 + side3 * side3)) { // Determine whether the triangle is right-angled
        System.out.println("Right-angled Triangle and Scalene Triangle"); // The triangle is Right-angled and Scalene
    } else { // The triangle is not right-angled
        System.out.println("Scalene Triangle"); // The triangle is Scalene
        
    }
}