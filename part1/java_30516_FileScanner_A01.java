import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_30516_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the current directory
        File currentDir = new File(".");

        // Create a FileFilter that only matches files with a .txt extension
        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use the listFiles method of File to get an array of File objects in the current directory
        File[] txtFiles = currentDir.listFiles(txtFilter);

        // If there are no text files in the current directory, print a message and exit
        if (txtFiles == null || txtFiles.length == 0) {
            System.out.println("No text files found in the current directory.");
            return;
        }

        // Print out the names of the text files
        System.out.println("Text files in the current directory: " + Arrays.toString(txtFiles));

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want to print out the names of the text files
        System.out.print("Do you want to print out the names of the text files (y/n)? ");
        String answer = scanner.next();

        // If the user answered yes, print out the names of the text files
        if (answer.equalsIgnoreCase("y")) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}