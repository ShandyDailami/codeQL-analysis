import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class java_21700_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            int wordCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                wordCount += countWords(line);
            }
            System.out.println("Line Count: " + lineCount);
            System.out.println("Word Count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(String line) {
        // This method is used to count the number of words in a line.
        // It's a simple implementation that splits the line by spaces.
        String[] words = line.split("\\s+");
        return words.length;
    }
}