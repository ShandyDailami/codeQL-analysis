import java.io.IOException;
import java.nio.file.*;

public class java_21826_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

        try {
            Files.walk(Paths.get("/path/to/directory"))
                .filter(path -> matcher.matches(path))
                .forEach(FileScannerExample::printFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFilePath(Path path) {
        System.out.println("File path: " + path.toString());
    }
}