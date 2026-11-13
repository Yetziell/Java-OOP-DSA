import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ComplexNumberAdder {

    public static void main(String[] args) {

        ComplexNumber total = new ComplexNumber(0, 0);

        try (Scanner scanner = new Scanner(new File("complex.txt"))) {

            while (scanner.hasNext()) {

                double realPart = scanner.nextDouble();
                double imaginaryPart = scanner.nextDouble();

                ComplexNumber number = new ComplexNumber(realPart, imaginaryPart);

                total = total.add(number);
            }

            System.out.println("Sum of complex numbers: " + total);

        } catch (FileNotFoundException e) {
            System.out.println("Error: complex.txt not found.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: Invalid complex number format.");
        }
    }
}
