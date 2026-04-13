import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_33625_FileScanner_A08 {
    private Scanner scanner;
    private File file;

    public java_33625_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
        if (!this.file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }
        this.scanner = new Scanner(file);
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in file: " + file.getPath());
        }
        return scanner.next();
    }

    public void close() {
        scanner.close();
    }
}