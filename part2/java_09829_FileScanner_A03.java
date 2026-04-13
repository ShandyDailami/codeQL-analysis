import java.nio.file.*;
import java.util.stream.*;

public class java_09829_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,log}");

        try (Stream<Path> paths = Files.find(Paths.get("."), Integer.MAX_VALUE, matcher)) {
            paths.forEach(FileScanner::process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Path path) {
        if (Files.isDirectory(path)) {
            return;
        }

        System.out.println("Processing file: " + path.getFileName());
        // Add your code here to handle the file
    }
}