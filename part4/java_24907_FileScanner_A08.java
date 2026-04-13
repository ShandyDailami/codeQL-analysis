import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24907_FileScanner_A08 {
    public static void main(String[] args) {
        // Initialize FileScanner
        File file = new File("src/main/resources/sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // Here, we are assuming the file is a text file with each line containing
                // a single word. We then check if the word is "A08_IntegrityFailure"
                if (line.equals("A08_IntegrityFailure")) {
                    System.out.println("A08_IntegrityFailure found in the file!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}