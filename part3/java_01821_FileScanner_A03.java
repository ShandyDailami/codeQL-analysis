import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_01821_FileScanner_A03 {

    private static final PathMatcher<Path> FILE_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory"; // replace with your directory
        scanDirectory(directory);
    }

    private static void scanDirectory(String directory) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            paths.filter(Files::isRegularFile)
                .filter(path -> FILE_MATCHER.matches(path))
                .forEach(FileScanner::handleFile);
        }
    }

    private static void handleFile(Path file) {
        System.out.println("Processing file: " + file.toString());
        // Here you can add your security-sensitive operations, such as reading and processing the file content
    }
}