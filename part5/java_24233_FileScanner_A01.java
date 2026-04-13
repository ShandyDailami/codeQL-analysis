import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24233_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new file scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for the directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a new file
        File file = new File(directoryPath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Check if the file is a directory
        if (!file.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        // Get all files in the directory
        File[] files = file.listFiles();

        // Check if any files exist
        if (files == null) {
            System.out.println("Directory is empty.");
            return;
        }

        // Print all file names
        System.out.println("Files in the directory: " + Arrays.toString(files));
    }
}