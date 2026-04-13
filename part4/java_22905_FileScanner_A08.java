import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22905_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a new File object for the directory
        File directory = new File(".");

        // Use a Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask for a directory name
        System.out.println("Enter directory name:");
        String dirName = scanner.next();

        // Get a File object for the directory
        File dirFile = new File(directory, dirName);

        // If the directory exists, print its contents
        if (dirFile.exists()) {
            System.out.println("Directory contents:");
            printDirectoryContents(dirFile);
        } else {
            System.out.println("Directory not found!");
        }

        // Close the scanner
        scanner.close();
    }

    private static void printDirectoryContents(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                printDirectoryContents(file);
            }
        }
    }
}