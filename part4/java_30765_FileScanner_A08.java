import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30765_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner instance
        FileScanner scanner = new FileScanner();

        // Use the scanner to read a file
        File file = new File("path/to/file.txt");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // process the line
            System.out.println(line);
        }

        // Close the scanner
        fileScanner.close();
    }
}

class FileScanner {
    // This is a simple implementation of a FileScanner, 
    // which only reads a file line by line
    private Scanner scanner;

    public java_30765_FileScanner_A08() throws FileNotFoundException {
        this.scanner = new Scanner(new File("path/to/file.txt"));
    }

    public String nextLine() {
        return this.scanner.nextLine();
    }

    public boolean hasNextLine() {
        return this.scanner.hasNextLine();
    }

    public void close() {
        this.scanner.close();
    }
}