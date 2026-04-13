import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_33833_FileScanner_A01 {
    private static final Path startingDirectory = Paths.get("C:\\temp\\");

    public static void main(String[] args) throws Exception {
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.filter(path -> Files.isRegularFile(path))
                .forEach(BrokenAccessControlExample::checkFilePermissions);
        }
    }

    private static void checkFilePermissions(Path path) {
        try {
            // Using java's SecurityManager to simulate broken access control
            if (path.toString().endsWith(".lock")) {
                throw new SecurityException("Access to file " + path + " is denied.");
            }
            Files.setPosixFilePermissions(path, Files.readLink(path).getPermissions().minus(Set.of(AccessPermission.delete())));
        } catch (Exception ex) {
            System.out.println("Failed to set permissions for " + path + ": " + ex.getMessage());
        }
    }
}