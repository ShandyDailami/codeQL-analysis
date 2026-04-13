import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37685_FileScanner_A01 {
    private String directoryPath;
    private File directory;

    public java_37685_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
        this.directory = new File(directoryPath);
    }

    public void scanDirectory() throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operations related to A01_BrokenAccessControl.
                        // Example: check for certain keywords in the line.
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    scanDirectory();
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        SecureFileScanner scanner = new SecureFileScanner(directoryPath);
        scanner.scanDirectory();
    }
}