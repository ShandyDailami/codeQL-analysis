import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13912_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        // Define the directory to scan
        File directory = new File("path/to/directory");

        // Scan files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Process the line here, no security issues
                    }
                    scanner.close();
                }
            }
        }
    }
}