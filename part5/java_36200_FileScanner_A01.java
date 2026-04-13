import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_36200_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Create a File object for the file
        File file = new File(dirPath + "/test.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // Create a File object for the file
        File file2 = new File(dirPath + "/test2.txt");

        // Check if the file exists
        if (file2.exists()) {
            System.out.println("File already exists.");
            return;
        }

        // Scan the file
        Scanner fileScanner = new Scanner(file);

        // Print out each line of the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner
        fileScanner.close();

        // Check if the file was successfully scanned
        if (!file.delete()) {
            System.out.println("Failed to delete file.");
        }
    }
}