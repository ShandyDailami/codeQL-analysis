import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30040_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory
        File directory = new File("path/to/directory");

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // If there are no files, exit the program
        if (files == null) {
            System.out.println("No files found in the directory");
            System.exit(1);
        }

        // Process each file
        for (File file : files) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    int lineNumber = 1;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line " + lineNumber + ": " + line);
                        lineNumber++;
                    }
                }
            }
        }
    }
}