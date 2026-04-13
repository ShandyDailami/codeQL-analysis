import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14293_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan.
        File directory = new File("C:\\path\\to\\directory");

        // Use the FileScanner to list all files in the directory.
        File[] files = directory.listFiles();

        // Ensure we didn't get any null or null files.
        if (files != null) {
            for (File file : files) {
                // Make sure the file is a file (not a directory) and not hidden.
                if (file.isFile() && !file.getName().startsWith(".")) {
                    try {
                        // Try to open the file for reading.
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            // Print each line of the file.
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        // If there was a problem opening the file, print an error message.
                        System.err.println("Unable to read file: " + file.getPath());
                    }
                }
            }
        }
    }
}