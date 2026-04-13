import java.io.File;
import java.util.Scanner;

public class java_04185_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Please enter a directory:");
        String directory = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(directory);

        // Check if the directory exists and is accessible
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory!");
            return;
        }

        // Create a File object for the current directory
        File[] files = dir.listFiles();

        // Check if there are files in the directory
        if (files == null) {
            System.out.println("No files found in the directory!");
            return;
        }

        // Print all the file names
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}