import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_10673_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path/to/directory");  // replace with your directory path
        getAllFilesRecursively(path);
    }

    public static void getAllFilesRecursively(Path path) throws IOException {
        try (Stream<Path> stream = Files.newStream(path.resolve("."))) {
            stream.forEach(Main::processFile);
        }
        Files.list(path).forEach(Main::getAllFilesRecursively);
    }

    private static void processFile(Path path) {
        // Security sensitive operations, such as printing the file path, here.
        System.out.println(path.toString());
    }
}