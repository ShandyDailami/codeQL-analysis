import java.io.*;
import java.nio.file.*;

public class java_26606_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File file = new File("path_to_your_file");

        try (FileScanner scanner = new FileVisitingScanner(Paths.get(file.toURI()))) {
            scanner.setAbsolutionWatchService(Paths.get("path_to_your_directory"));
            scanner.setInWatchService(file);
            scanner.addListener();
        }

        // Additional code here
    }
}