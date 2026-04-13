import java.io.File;
import java.util.Scanner;

public class java_01572_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Prompt the user for the file name
        System.out.println("Please enter the file name:");
        String fileName = scanner.nextLine();

        // Construct the File object
        File file = new File(directoryPath, fileName);

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }

        // Close the scanner
        scanner.close();
    }
}