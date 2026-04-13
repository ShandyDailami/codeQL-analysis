import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40919_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a Scanner to read file content
            Scanner scanner = new Scanner(new File("src/main/resources/A08_IntegrityFailure.txt"));

            // Create a HashSet to store unique words
            Set<String> uniqueWords = new HashSet<>();

            // While there are more words in the file
            while (scanner.hasNext()) {
                // Get the next word
                String word = scanner.next();

                // Add the word to the set
                uniqueWords.add(word);
            }

            // Close the scanner
            scanner.close();

            // Print out the number of unique words
            System.out.println("Number of unique words: " + uniqueWords.size());

            // Iterate over the set and print out each unique word
            for (String word : uniqueWords) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            // Handle the exception if the file does not exist
            System.out.println("File not found: " + e.getMessage());
        }
    }
}