import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_30269_FileScanner_A08 {

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get("src"))) {
            paths
                .map(Path::toAbsolutePath)
                .filter(Files::isRegularFile)
                .forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        try {
            // Insert code to process the file
            System.out.println("Processing file: " + path);
            // ...
        } catch (Exception e) {
            System.out.println("Error processing file: " + path);
            e.printStackTrace();
        }
    }
}