import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11958_FileScanner_A01 {
    private FileScanner fileScanner;

    public java_11958_FileScanner_A01(FileScanner fileScanner) {
        this.fileScanner = fileScanner;
    }

    public void scanDirectory(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);
        fileScanner.scan(directory, "*.txt");
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner fileScanner = new FileScanner();
        BrokenAccessControl accessControl = new BrokenAccessControl(fileScanner);
        accessControl.scanDirectory("/path/to/your/directory");
    }
}