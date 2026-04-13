import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_05523_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("./src/main/resources");

        // This will list all files in the specified directory and its subdirectories
        try (Stream<Path> paths = Files.walk(path, 1)) {
            paths.forEach(FileScanner::processFile);
        }
    }

    private static void processFile(Path path) {
        // This method reads all content from the file and prints it to the console.
        // You can replace this with your own logic for security-sensitive operations.
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
    }
}