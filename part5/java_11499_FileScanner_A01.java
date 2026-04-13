import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11499_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner object
        FileScanner scanner = new FileScanner();

        // Open the file
        scanner.open("path/to/your/file.txt");

        // Loop through the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Line " + (scanner.lineNumber() + 1) + ": " + line);
        }

        // Close the file
        scanner.close();
    }
}

class FileScanner {
    private Scanner fileScanner;

    public void open(String filePath) throws FileNotFoundException {
        this.fileScanner = new Scanner(new File(filePath));
    }

    public boolean hasNextLine() {
        return fileScanner.hasNextLine();
    }

    public String nextLine() {
        return fileScanner.nextLine();
    }

    public int lineNumber() {
        return fileScanner.nextLine();
    }

    public void close() {
        fileScanner.close();
    }
}