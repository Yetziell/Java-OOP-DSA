import java.util.Scanner;

public class GreatestCommonDivisor {

    public static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }

        return gcd(secondNumber, firstNumber % secondNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        scanner.close();

        if (firstNumber == 0 && secondNumber == 0) {
            System.out.println("The GCD of 0 and 0 is undefined.");
            return;
        }

        int result = gcd(
            Math.abs(firstNumber),
            Math.abs(secondNumber)
        );

        System.out.println(
            "The GCD of " + firstNumber +
            " and " + secondNumber + " is: " + result
        );
    }
}
