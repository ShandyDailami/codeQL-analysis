import java.io.File;
import java.util.Scanner;

public class java_04716_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the directory from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String directoryPath = scanner.nextLine();

        // Validate the directory path
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Invalid directory path. Please try again.");
            return;
        }

        // Scan the directory for files
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        // Print the list of files
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}