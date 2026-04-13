import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34089_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the directory to scan
        File directory = new File(".");

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if there are files
        if (files != null) {
            // Loop through all files
            for (File file : files) {
                // Check if the file is a regular file (not a directory or a device file)
                if (file.isFile()) {
                    try {
                        // Try to open the file and create a Scanner for it
                        try (Scanner scanner = new Scanner(file)) {
                            // Print the contents of the file
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}