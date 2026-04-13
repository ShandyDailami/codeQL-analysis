import java.nio.file.*;
import java.util.stream.*;

public class java_26716_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        Path startingPath = Paths.get(".");
        int fileCount = countFiles(startingPath);
        System.out.println("Found " + fileCount + " files.");
    }

    private static int countFiles(Path path) {
        try (Stream<Path> stream = Files.list(path)) {
            return stream.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            // Handle the exception here
            System.err.println("Error reading directory " + path);
            return 0;
        }
    }
}