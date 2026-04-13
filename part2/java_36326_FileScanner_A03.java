import java.nio.file.*;
import java.util.stream.*;

public class java_36326_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";

        try (Stream<Path> paths = Files.walk(Paths.get(dirPath))) {
            paths.filter(Files::isRegularFile)
                 .map(Path::toString)
                 .map(Main::isJavaFile)
                 .filter(Main::isSensitive)
                 .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isJavaFile(String path) {
        return path.endsWith(".java");
    }

    private static boolean isSensitive(String path) {
        // Implement your security-sensitive operations here.
        // For instance, we'll assume a file is potentially sensitive if it contains any injection attempts
        return path.contains("inject");
    }
}