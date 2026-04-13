import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_30617_FileScanner_A03 {

    private static final String SRC_DIR = "src";
    private static final String SECURITY_INJECTION_REGEX = "(?i)injection";

    public static void main(String[] args) throws IOException, PatternSyntaxException {
        Path path = Paths.get(SRC_DIR);

        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(SecurityScanner::processPath);
        }
    }

    private static void processPath(Path path) {
        try {
            Files.newBufferedReader(path);
            String content = Files.readAllLines(path).toString();
            checkForSecurityInjection(content);
        } catch (IOException e) {
            System.out.println("Error processing path: " + path);
        }
    }

    private static void checkForSecurityInjection(String content) {
        if (content.contains(SECURITY_INJECTION_REGEX)) {
            System.out.println("Security injection detected in: " + content);
        }
    }
}