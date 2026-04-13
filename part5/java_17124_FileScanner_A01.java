import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17124_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Get the file to search for
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // Create a File object for the directory and the file to search
        File dir = new File(dirPath);
        File file = new File(dirPath + "/" + fileName);

        // Check if the file exists and if it can be read
        if (file.exists() && file.canRead()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found or not accessible.");
        }

        // Close the scanner
        scanner.close();
    }
}