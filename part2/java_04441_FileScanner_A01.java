import java.io.File;
import java.util.Scanner;

public class java_04441_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a new File instance for the directory to be scanned
        File directory = new File(".");

        // Create a new Scanner instance for reading the file names
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory to be scanned
        System.out.println("Enter the directory to be scanned:");
        String directoryPath = scanner.nextLine();

        // Check if the user has entered a valid directory path
        if (!directory.exists()) {
            System.out.println("Invalid directory path.");
            return;
        }

        // Scan the directory
        scanDirectory(directory, directoryPath);
    }

    private static void scanDirectory(File directory, String directoryPath) {

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files == null) {
            return;
        }

        // Print the directory path and the names of all the files in it
        System.out.println("Directory path: " + directoryPath);
        for (File file : files) {
            System.out.println("File name: " + file.getName());
       
            // Check if the file is a directory
            if (file.isDirectory()) {

                // If the file is a directory, scan it
                scanDirectory(file, directoryPath + "/" + file.getName());
            }
        }
    }
}