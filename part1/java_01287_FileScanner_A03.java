import java.io.File;
import java.util.Scanner;

public class java_01287_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new File instance for the directory to scan
        File directory = new File(".");

        // Use a Scanner to scan the directory
        Scanner scanner = new Scanner(System.in);

        // Print out all the files in the directory
        if (directory.isDirectory()) {
            System.out.println("Files in directory:");
            for (File file : directory.listFiles()) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Error: " + directory + " is not a directory");
        }

        // Close the scanner
        scanner.close();
    }
}