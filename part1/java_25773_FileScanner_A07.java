import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25773_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new file scanner
        Scanner fileScanner = new Scanner(System.in);

        // Request for a file path
        System.out.println("Enter the file path:");
        String filePath = fileScanner.nextLine();

        // Create a new file
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("Given path is a directory, not a file");
            return;
        }

        // Check if the user has permission to read the file
        if (!file.canRead()) {
            System.out.println("User does not have permission to read the file");
            return;
        }

        // Check if the user has permission to write to the file
        if (!file.canWrite()) {
            System.out.println("User does not have permission to write to the file");
            return;
        }

        // Create a new file scanner for reading the file
        try (Scanner fileScannerForReading = new Scanner(file)) {
            while (fileScannerForReading.hasNextLine()) {
                String line = fileScannerForReading.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}