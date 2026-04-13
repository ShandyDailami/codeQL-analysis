import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07953_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory where the files are located
        File directory = new File("C:\\Windows");

        // Use a try-with-resources statement to automatically close the scanner
        try (Scanner scanner = new Scanner(directory)) {
            // Process each file in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(fileName);

                // Check if the file is a directory
                if (file.isDirectory()) {
                    // Check if the file has read permissions
                    if (!file.canRead()) {
                        System.out.println("Error: The file " + fileName + " can't be read");
                    }
                }
            }
        }
    }
}