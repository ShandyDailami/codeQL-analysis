import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27873_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner for the user to enter the directory to scan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory to scan: ");
        String directoryPath = scanner.nextLine();

        // Get the directory object
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Scan the directory for files
        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        // Print the names of the files
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}