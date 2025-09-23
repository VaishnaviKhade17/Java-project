import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input weight and height
        System.out.print("Enter weight in pounds: ");
        double weightPounds = sc.nextDouble();

        System.out.print("Enter height in inches: ");
        double heightInches = sc.nextDouble();

        // Convert to metric units
        double weightKg = weightPounds * 0.45359237;
        double heightM = heightInches * 0.0254;

        // Calculate BMI
        double bmi = weightKg / (heightM * heightM);

        // Display BMI
        System.out.printf("Your BMI is: %.2f\n", bmi);

        // Interpret BMI
        if (bmi < 18.5) {
            System.out.println("You are Underweight.");
        } else if (bmi < 25.0) {
            System.out.println("You are Normal.");
        } else if (bmi < 30.0) {
            System.out.println("You are Overweight.");
        } else {
            System.out.println("You are Obese.");
        }

        sc.close();
    }
}
