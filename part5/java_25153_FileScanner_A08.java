import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25153_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory path
        String directoryPath = "path/to/directory";

        // Get the directory object
        File directory = new File(directoryPath);

        // Use the file enumeration to read files
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    // Use a scanner to read the file content
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Add your security-sensitive operation here
                        // For example, checking file integrity
                        if (!fileIntegrityCheck(line)) {
                            System.out.println("File integrity check failed: " + file.getName());
                        }
                    }
                    scanner.close();
                }
            }
        }
    }

    // This method is not secure. It is just for demonstration purposes
    private static boolean fileIntegrityCheck(String line) {
        // Insert your security-sensitive operation here
        // For example, checking MD5 hash of a line
        // Here we just return true to simulate a failed integrity check
        return true;
    }
}