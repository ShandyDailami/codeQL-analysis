import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38513_FileScanner_A01 {
    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "/path/to/directory";

        // Get the directory object
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists()) {
            // Get all the files in the directory
            File[] files = directory.listFiles();

            // If files exists, iterate over them
            if (files != null) {
                for (File file : files) {
                    // Check if the file is a regular file and not a directory
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            // Process each line in the file
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // TODO: Implement your security-sensitive operations here
                                // For example, check for broken access control
                                if (line.contains("BROKEN_ACCESS_CONTROL")) {
                                    System.out.println("Broken access control detected in file: " + file.getAbsolutePath());
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}