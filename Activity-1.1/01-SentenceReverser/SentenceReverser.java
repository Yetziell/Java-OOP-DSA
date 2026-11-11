import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class SentenceReverser {

    public static String reverse(String originalSentence) {
        String reversedSentence = "";

        for (int index = originalSentence.length() - 1; index >= 0; index--) {
            reversedSentence += originalSentence.charAt(index);
        }

        return reversedSentence;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide a sentence to be reversed: ");
        String originalSentence = scanner.nextLine();

        String reversedSentence = reverse(originalSentence);

        try (FileWriter fileWriter = new FileWriter("rev.txt")) {
            fileWriter.write(reversedSentence);
            System.out.println("Reversed sentence saved to rev.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}