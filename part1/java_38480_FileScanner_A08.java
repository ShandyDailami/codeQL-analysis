import java.io.File;
import java.util.Scanner;

public class java_38480_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            int words = 0;
            int letters = 0;
            int specialChars = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] wordsInLine = line.split("\\s+");
                words += wordsInLine.length;

                for (String word : wordsInLine) {
                    letters += word.length();
                    if (!word.matches("^[a-zA-Z0-9]*$")) {
                        specialChars++;
                    }
                }
            }

            System.out.println("Number of words: " + words);
            System.out.println("Number of letters: " + letters);
            System.out.println("Number of special characters: " + specialChars);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}