import java.io.IOException;
import java.nio.file.*;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControlException;

public class java_26737_FileScanner_A03 {
    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";

    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.out.println("No security manager detected.");
            System.exit(1);
        }
        try {
            securityManager.checkPermission(new java.security.AccessibleOperationException("read"));
            System.out.println("Permission granted.");
        } catch (AccessControlException e) {
            System.out.println("Permission denied.");
            System.exit(1);
        }

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        try (DirectoryStream<Path> nonSecureFiles = Files.newDirectoryStream(Paths.get(DIRECTORY_TO_SCAN))) {
            for (Path path : nonSecureFiles) {
                if (matcher.matches(path.toString())) {
                    try (Stream<String> lines = Files.lines(path)) {
                        lines.forEach(line -> {
                            // Perform some operation on the file here
                            System.out.println("Processing file: " + path);
                        });
                    } catch (IOException e) {
                        System.out.println("Error processing file: " + path);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error scanning directory: " + DIRECTORY_TO_SCAN);
        }
    }
}