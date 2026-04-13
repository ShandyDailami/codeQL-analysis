import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15392_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Set the directory path
        String directoryPath = "/path/to/your/directory";

        // Get the directory
        File directory = new File(directoryPath);

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files != null) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isFile()) {
                    // Create a scanner for the file
                    Scanner fileScanner = new Scanner(file);

                    // Loop through each line in the file
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }

                    // Close the scanner
                    fileScanner.close();
                }
            }
        } else {
            System.out.println("No files in the directory");
        }
    }
}