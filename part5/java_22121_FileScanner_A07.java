import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_22121_FileScanner_A07 {

    private static final PathMatcher PATH_MATCHER = FileSystems.getDefault().getPathMatcher("glob:*.java");

    private static final String SECURITY_SENSITIVE_OPERATION_CLASS_NAME = "YOUR_SECURITY_SENSITIVE_OPERATION_CLASS_NAME";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("YOUR_DIRECTORY_PATH");
        findSecuritySensitiveFiles(path);
    }

    private static void findSecuritySensitiveFiles(Path path) throws IOException {
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(FileScanner::processPath);
        }
    }

    private static void processPath(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)
                && PATH_MATCHER.matches(path.getFileName().toString())) {
            try {
                if (isSecuritySensitiveOperation(path)) {
                    System.out.println("Security sensitive operation found: " + path);
                }
            } catch (Exception e) {
                System.err.println("Error processing path: " + path + ": " + e.getMessage());
            }
        }
    }

    private static boolean isSecuritySensitiveOperation(Path path) throws Exception {
        Class<?> clazz = Class.forName(SECURITY_SENSITIVE_OPERATION_CLASS_NAME);
        Method method = clazz.getMethod("isSecuritySensitiveOperation", Path.class);
        return (boolean) method.invoke(null, path);
    }
}