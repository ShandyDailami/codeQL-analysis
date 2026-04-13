import java.io.IOException;
import java.nio.file.*;

public class java_01175_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/directory"), matcher)
            .forEach(Main::processFile);
    }

    private static void processFile(Path file) {
        try {
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            long size = attrs.size();
            System.out.printf("File '%s' has size %d bytes%n", file.getFileName(), size);
        } catch (IOException e) {
            System.err.printf("Failed to read attributes of file '%s'%n", file);
        }
    }
}