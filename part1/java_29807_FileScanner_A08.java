import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_29807_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt"); // Path to your file
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Check if line contains "A08_IntegrityFailure"
            if (line.contains("A08_IntegrityFailure")) {
                System.out.println("Found line: " + line);
            }
        }

        scanner.close();
    }
}