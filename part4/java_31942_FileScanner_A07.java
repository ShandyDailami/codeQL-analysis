import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31942_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File("."); // Get the current directory
        String extension = ".txt"; // The file extension we're looking for
        scanFiles(directory, extension);
    }

    private static void scanFiles(File directory, String extension) {
        try (FileScanner scanner = new FileTxtScanner()) { // Create a FileScanner for .txt files
            scanner.scan(directory, ((file, attrs) -> file.getName().endsWith(extension))); // Scan the directory
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileTxtScanner extends java.io.FileScanner {

    @Override
    public void init(File file, String string) throws FileNotFoundException {
        // This is a no-op, but we have to override it to get a FileScanner
    }
}