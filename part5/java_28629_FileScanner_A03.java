import java.io.File;
import java.util.Scanner;

public class java_28629_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // If the directory exists, list all files in it
        if (directory.exists()) {
            File[] files = directory.listFiles();

            // Print all file names
            if (files != null) {
                for (File file : files) {
                    if (!file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        // Close the scanner
        scanner.close();
    }
}