import java.nio.file.*;
import java.util.stream.*;

public class java_26706_FileScanner_A03 {

    // This is a simple example of how you can use PathMatcher to find files.
    // In a real-world application, you would use a more sophisticated tool.
    private static boolean isFileUnderTest(Path path) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.anyMatch(x -> x.toString().endsWith("_test.txt"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        PathMatcher matcher = Paths.get(".").getFileSystem().getPathMatcher("glob:**/test.txt");

        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(p -> matcher.matches(p.getFileName()))
                .filter(Main::isFileUnderTest)
                .forEach(Main::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is a simple example of how you can process a file.
    // In a real-world application, you would use a more sophisticated tool.
    private static void processFile(Path path) {
        System.out.println("Processing file: " + path);
        // TODO: Implement your security-sensitive operations here.
    }
}