import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

public class java_37497_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner
        FileSystems fileSystems = FileSystems.getDefault();
        Path startingDirectory = fileSystems.getPath("src/main/java");
        Iterator<Path> paths = fileSystems.newFileIterator(startingDirectory);

        // Create a scanner to read file names
        try (Scanner scanner = new Scanner(System.in)) {
            while (paths.hasNext()) {
                Path path = paths.next();
                if (path.toString().endsWith(".java")) {
                    // Print the file name
                    System.out.println(path.toString());
                }
            }
        }
    }
}