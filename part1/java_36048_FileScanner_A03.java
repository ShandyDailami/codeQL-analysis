import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_36048_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the path from command line arguments
        String path = args[0];

        // Create a FileScanner
        FileScanner scanner = new FileScanner(path);

        // Report the size of the file
        reportFileSize(scanner.getPath());
    }

    public static void reportFileSize(Path path) {
        try (FileReader reader = new FileReader(path.toFile())) {
            long length = Files.size(path);
            System.out.println("Size of " + path + " = " + length);
        } catch (IOException e) {
            System.out.println("Error reading file " + path);
        }
    }
}