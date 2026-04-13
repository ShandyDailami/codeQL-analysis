import java.io.File;
import java.util.Scanner;

public class java_15513_FileScanner_A07 {

    // The scanner to read input from the command line.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Prompt the user to enter a directory path.
        System.out.println("Enter a directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory.
        File directory = new File(directoryPath);

        // Check if the directory exists.
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            System.exit(1);
        }

        // Check if the directory is a directory.
        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            System.exit(1);
        }

        // Get all files in the directory.
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in directory.");
            System.exit(1);
        }

        // Print all files in the directory.
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}