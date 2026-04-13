import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04785_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Use a secure directory to scan
        File directory = new File("/path/to/directory");

        // Use a secure scanner to read the files
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a file name to search for:");
            String fileName = scanner.nextLine();

            // Use a FileScanner to find the file
            File file = new File(directory, fileName);

            // Check if the file exists and can be read
            if (file.exists() && file.canRead()) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found or not readable");
            }
        }
    }
}