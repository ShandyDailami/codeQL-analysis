import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17172_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new file object for the directory
        File dir = new File(".");

        // Use a try-with-resources statement to automatically close the scanner
        try (Scanner scanner = new Scanner(dir)) {
            // Use a while loop to read the files in the directory
            while (scanner.hasNext()) {
                // Get the next file name
                String fileName = scanner.next();

                // Print the file name
                System.out.println("Reading file: " + fileName);

                // Create a new file object for the file
                File file = new File(fileName);

                // Use a try-with-resources statement to automatically close the scanner
                try (Scanner fileScanner = new Scanner(file)) {
                    // Use a while loop to read the file contents
                    while (fileScanner.hasNext()) {
                        // Get the next line from the file
                        String line = fileScanner.nextLine();

                        // Print the line
                        System.out.println("File contents: " + line);
                    }
                }
            }
        }
    }
}