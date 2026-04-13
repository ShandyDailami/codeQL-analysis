import java.io.File;
import java.util.Scanner;

public class java_32368_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a Scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory path
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Check if the directory is a directory
        if (!dir.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        // Use a File object to iterate over all files in the directory
        File[] files = dir.listFiles();

        // If there are no files, exit the program
        if (files == null) {
            System.out.println("No files in the directory!");
            return;
        }

        // Print out the names of all the files in the directory
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}