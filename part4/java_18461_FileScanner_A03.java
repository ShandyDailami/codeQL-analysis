import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_18461_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory
        System.out.println("Please enter a directory:");
        String directory = scanner.nextLine();

        // Get the files in the directory
        File dir = new File(directory);
        File[] files = dir.listFiles();

        // If there are no files, print a message
        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        // Print the names of the files
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}