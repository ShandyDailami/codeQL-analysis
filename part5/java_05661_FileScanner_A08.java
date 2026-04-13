import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05661_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Start scanning from the current directory
            File dir = new File(".");
            // Use a FileScanner to scan all files in the current directory and its subdirectories
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Use a Scanner to read the file content
                        Scanner scanner = new Scanner(file);
                        // Keep reading until there are no more tokens
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Check if the line contains the word 'password'
                            if (line.contains("password")) {
                                System.out.println("Security alert: File " + file.getPath() + " contains sensitive information");
                            }
                        }
                        // Close the Scanner
                        scanner.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}