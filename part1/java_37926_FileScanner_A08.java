import java.io.File;
import java.util.Scanner;

public class java_37926_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a FileScanner for the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Scan files in the directory
        while (scanner.hasNext()) {
            String fileName = scanner.nextLine();
            System.out.println(fileName);
        }

        // Close the FileScanner
        scanner.close();
    }
}

class FileScanner {
    private File file;

    public java_37926_FileScanner_A08(File file) {
        this.file = file;
    }

    public boolean hasNext() {
        return file.exists();
    }

    public String nextLine() {
        return file.getName();
    }

    public void close() {
        // No-op, as we only use standard libraries
    }
}