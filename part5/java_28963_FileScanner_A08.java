import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28963_FileScanner_A08 {

    // Define the directory to scan
    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";

    // Define the file types to exclude
    private static final String[] EXCLUDED_FILE_TYPES = { ".exe", ".dll", ".pdf" };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            File directory = new File(DIRECTORY_TO_SCAN);
            getFileList(directory, scanner);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getFileList(File directory, Scanner scanner) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileIntegrityOk(file)) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    getFileList(file, scanner);
                }
            }
        }
    }

    private static boolean isFileIntegrityOk(File file) {
        // You would typically implement a security-sensitive operation here
        // For example, you could check if the file is within a specific size,
        // or if the file has a specific hash, or if the file is within a certain
        // age, etc.

        // This example simply returns true, since we are not implementing
        // a security-sensitive operation.
        return true;
    }
}