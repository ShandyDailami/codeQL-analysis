import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_23351_FileScanner_A03 {

    private final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public void listTextFiles(Path startingPath) throws IOException {
        try (Stream<Path> paths = Files.list(startingPath).filter(path -> pathMatcher.matches(path))) {
            paths.forEach(this::processFile);
        }
    }

    private void processFile(Path file) {
        System.out.println("Processing file: " + file.toString());
        // implement security sensitive operations here, e.g. reading the file, processing it, etc.
    }

    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get("path_to_start_from");
        new FileScanner().listTextFiles(startingPath);
    }
}