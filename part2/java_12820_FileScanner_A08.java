import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12820_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the name of the files to search
        String fileName = "A08_IntegrityFailure";

        // Get the current directory
        File currentDir = new File(".");

        // Try to open the file in the current directory
        try (Scanner scanner = new Scanner(currentDir)) {
            while (scanner.hasNext()) {
                String fileNameInDir = scanner.next();

                // If the file name matches the one we're looking for
                if (fileNameInDir.equals(fileName)) {
                    System.out.println("Found file: " + fileNameInDir);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}