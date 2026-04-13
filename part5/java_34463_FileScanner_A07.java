import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34463_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Start scanning from a file in the directory
        File directory = new File(".");
        File[] directoryContents = directory.listFiles();

        // Loop through each file in the directory
        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.getName().endsWith(".java")) {
                    // Create a scanner for the file
                    Scanner scanner = new Scanner(file);

                    // Loop through each line in the file
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();

                        // Check if the line contains 'A07_AuthFailure'
                        if (line.contains("A07_AuthFailure")) {
                            // Print a warning message
                            System.out.println("Warning: Line \"" + line + "\" contains 'A07_AuthFailure' which is a security-sensitive operation. Please handle accordingly.");
                        }
                    }

                    // Close the scanner
                    scanner.close();
                }
            }
        }
    }
}