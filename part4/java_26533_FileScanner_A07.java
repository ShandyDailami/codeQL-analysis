import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuaranteedAccessException;
import java.security.Permission;
import java.security.Policy;
import java.util.stream.Stream;

public class java_26533_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths
                .filter(path -> path.toString().endsWith(".txt"))
                .map(Path::toFile)
                .forEach(file -> {
                    try {
                        checkAccess(file);
                        System.out.println(file.getAbsolutePath());
                    } catch (AccessDeniedException e) {
                        System.err.println("Access denied for: " + file.getAbsolutePath());
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkAccess(File file) throws AccessDeniedException, AccessControlException {
        Policy policy = System.getSecurityManager().getPolicy();
        if (policy == null) {
            throw new AccessControlException("Policy is null");
        }
        Permission permission = new FilePermission(file.getAbsolutePath(), "read");
        policy.checkPermission(permission);
    }
}