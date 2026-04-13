import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40757_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Prompt the user for a directory to scan
            System.out.println("Enter the directory to scan:");
            Scanner scanner = new Scanner(System.in);
            String directoryPath = scanner.nextLine();

            // Create a File object for the given directory
            File directory = new File(directoryPath);

            // Scan the directory for files
            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            // Print the file name
                            System.out.println("File name: " + file.getName());
                        } else if (file.isDirectory()) {
                            // Print the directory name
                            System.out.println("Directory name: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files found in the directory.");
                }
            } else {
                System.out.println("The provided directory does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}