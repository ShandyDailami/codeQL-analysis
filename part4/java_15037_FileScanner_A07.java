import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15037_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object to represent the directory
        File directory = new File("path/to/directory");

        // Create a File object for each file in the directory
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                // Create a Scanner object to read the file
                Scanner scanner = new Scanner(file);

                // Read and print the contents of the file
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                // Close the scanner
                scanner.close();
            }
        }
    }
}