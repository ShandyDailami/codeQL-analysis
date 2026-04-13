import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00669_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for reading the user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Enter a directory:");
        String directory = scanner.nextLine();

        // Get all files in the directory
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        // Print all files
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}