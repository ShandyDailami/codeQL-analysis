import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23677_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner that goes through the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Use a scanner to read the content of each file in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println("File: " + file.getName());

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println("Line: " + line);
                }
            }

            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}

class FileScanner {
    private File[] files;
    private int current;

    public java_23677_FileScanner_A07(File root) {
        this.files = root.listFiles();
        this.current = -1;
    }

    public boolean hasNext() {
        return this.current < this.files.length - 1;
    }

    public File nextFile() {
        return this.files[++this.current];
    }

    public void close() {
        // Do nothing, we don't need to close this scanner
    }
}