import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberOperations {

    public static void main(String[] args) {

        ArrayList<Double> numbers = new ArrayList<>();

        // Read numbers from the file
        try (Scanner scanner = new Scanner(new File("numbers.txt"))) {

            while (scanner.hasNext()) {
                if (!scanner.hasNextDouble()) {
                    System.out.println("Error: Invalid number in file.");
                    return;
                }

                numbers.add(scanner.nextDouble());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (numbers.size() != 5) {
            System.out.println("Error: Exactly five numbers are required.");
            return;
        }

        Collections.sort(numbers);

        double smallestNumber = numbers.get(0);
        double greatestNumber = numbers.get(numbers.size() - 1);

        double sum = smallestNumber + greatestNumber;

        try (FileWriter fileWriter = new FileWriter("numbers.txt")) {

            for (double number : numbers) {
                fileWriter.write(number + System.lineSeparator());
            }

            System.out.println("Numbers sorted successfully.");
            System.out.println("Smallest number: " + smallestNumber);
            System.out.println("Greatest number: " + greatestNumber);
            System.out.println("Sum: " + sum);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
