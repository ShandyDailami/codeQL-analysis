import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_38319_FileScanner_A03 {
    private static final PathMatcher<Path> FILE_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".");
        try (Stream<Path> results = Files.walk(startingPath)) {
            results.forEach(FileScanner::printFileOrDirectory);
        }
    }

    private static void printFileOrDirectory(Path path) {
        boolean isFile = Files.isRegularFile(path);
        if (isFile) {
            System.out.println(path.toString());
        } else if (Files.isDirectory(path)) {
            if (FILE_MATCHER.matches(path.getFileName())) {
                System.out.println("Directory: " + path.toString());
            }
        }
    }
}