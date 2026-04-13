import java.io.File;
import java.util.Scanner;

public class java_28914_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a File object for the directory to be scanned
        File directory = new File(".");

        // Use a scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask for a directory to scan
        System.out.println("Enter a directory to scan:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory to be scanned
        File dir = new File(directoryPath);

        // Use a FileScanner to list all files in the directory and its subdirectories
        if (dir.exists()) {
            FileScanner fileScanner = new FileScanner(dir);
            for (File file : fileScanner) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found.");
        }

        // Close the scanner
        scanner.close();
    }
}