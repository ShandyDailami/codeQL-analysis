import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40313_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Ask for the directory path
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Ensure the directory exists
        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        // Ensure the user has necessary permissions to read the directory
        if (!directory.canRead()) {
            System.out.println("The current user does not have sufficient permissions to read the directory.");
            return;
        }

        // List all the files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}