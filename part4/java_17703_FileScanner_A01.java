import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17703_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Set the directory where the files are located
        String directoryPath = "/path/to/your/directory";

        // Create a FileScanner to scan files in a directory
        FileScanner fileScanner = new FileScanner(new File(directoryPath));

        // Use a Scanner to read the files in the directory
        Scanner scanner = fileScanner.getScanner();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // This is a security-sensitive operation.
            // If the line contains a suspicious word, print a warning message.
            if (line.contains("suspicious")) {
                System.out.println("WARNING: Suspicious content detected in a file!");
            }
        }

        // Close the scanner when done
        scanner.close();
    }
}

class FileScanner {
    private File file;
    private Scanner scanner;

    public java_17703_FileScanner_A01(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
    }

    public Scanner getScanner() {
        return scanner;
    }
}