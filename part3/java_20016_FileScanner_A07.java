import java.io.File;
import java.util.Scanner;

public class java_20016_FileScanner_A07 {

    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Create a new FileScanner to scan files in the current directory
        FileScanner scanner = new FileScanner(currentDir);

        // Use the scanner to print out the names of the files it finds
        scanner.forEach(file -> System.out.println(file.getName()));
    }
}

class FileScanner {
    private File file;

    public java_20016_FileScanner_A07(File file) {
        this.file = file;
    }

    public void forEach(Action<File> action) {
        // This method is intentionally left blank. It will be implemented in a future Java version.
    }
}