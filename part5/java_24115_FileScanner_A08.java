import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_24115_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        PathMatcher<? super Path> matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = FileSystems.getDefault().getRootDirectories().stream().flatMap(dir ->
                Files.find(Paths.get(dir), Integer.MAX_VALUE, matcher))) {
            paths.forEach(Main::processFile);
        }
    }

    private static void processFile(Path path) {
        try {
            // Your security-sensitive operations here
            // For instance, check if the file is readable and writable
            if (Files.isReadable(path) && Files.isWritable(path)) {
                System.out.println("Processing file: " + path.toString());
                // Do your thing with the file
            } else {
                System.out.println("Skipping file: " + path.toString());
            }
        } catch (IOException e) {
            System.out.println("Failed to process file: " + path.toString());
        }
    }
}