import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11593_FileScanner_A03 {
    public static void main(String[] args) {
        // File path will be hardcoded for simplicity
        String filePath = "/path/to/files";

        // Get all files from the directory
        File directory = new File(filePath);
        File[] files = directory.listFiles();

        // Print all file names
        System.out.println("Files in the directory: " + Arrays.toString(files));

        // Prompt user for a file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name to search:");
        String fileName = scanner.next();

        // Search for the file in the list
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getPath());
                break;
            }
        }

        // Close scanner
        scanner.close();
    }
}