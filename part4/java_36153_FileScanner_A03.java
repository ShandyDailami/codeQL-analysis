import java.io.File;
import java.nio.file.*;

public class java_36153_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.exe");

        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/directory"))) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> matcher.matches(path.getFileName()))
                 .forEach(Main::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        // Here you can implement your security-sensitive operations related to A03_Injection
        // For example, you can use a hash function to check if the file content is a known malicious one
        // However, please note that the example below is just a placeholder and does not have any security-sensitive operations.

        System.out.println("Processing file: " + path);
    }
}