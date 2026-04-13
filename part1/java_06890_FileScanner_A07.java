import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06890_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a File object to represent the directory we wish to scan.
        File directory = new File(".");

        // Use the `listFiles` method to get all files in the directory.
        File[] fileList = directory.listFiles();

        // If we have any files to scan, then we iterate over them.
        if (fileList != null) {
            for (File file : fileList) {
                // Skip the directories.
                if (file.isFile()) {
                    // Open a scanner for the file.
                    Scanner scanner = new Scanner(file);

                    // Use a try-with-resources statement to automatically close the scanner.
                    try (scanner) {
                        // Scan the file.
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here, you can add your security-sensitive operation.
                            // For example, here, we're just printing out each line of the file.
                            System.out.println(line);
                        }
                    }
                }
            }
        }
    }
}