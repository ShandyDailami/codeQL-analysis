import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Scanner;

public class java_15544_FileScanner_A03 {

    public static void main(String[] args) {
        // Create a Scanner for the user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a directory
        System.out.print("Enter a directory: ");
        String directory = scanner.nextLine();

        // Ask the user for a file extension
        System.out.print("Enter a file extension: ");
        String extension = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(directory);

        // Create a File[] for the directory
        File[] listOfFiles = dir.listFiles();

        // Loop through each file in the directory
        for (File file : listOfFiles) {
            // If the file is a file and has the correct extension
            if (file.isFile() && file.getName().endsWith(extension)) {
                // Open the file for reading
                try (Scanner fileScanner = new Scanner(file)) {
                    // Loop through the file
                    while (fileScanner.hasNextLine()) {
                        // Get the next line
                        String line = fileScanner.nextLine();
                        // Print the line
                        System.out.println(line);
                    }
                }
            }
        }
    }
}