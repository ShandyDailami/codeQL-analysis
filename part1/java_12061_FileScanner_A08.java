import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecurityManager;
import java.security.UnsupportedOperationException;

public class java_12061_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        FileVisitor fileVisitor = new FileVisitor(new SecurityManager());
        Files.walkFileTree(directory.toPath(), fileVisitor);
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        private final SecurityManager securityManager;

        public java_12061_FileScanner_A08(SecurityManager securityManager) {
            this.securityManager = securityManager;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!securityManager.checkFilePermission(file.toFile(), "read")) {
                throw new SecurityFailureException("File permission denied for reading: " + file);
            }

            if (!securityManager.checkFilePermission(file.toFile(), "write")) {
                throw new SecurityFailureException("File permission denied for writing: " + file);
            }

            // Continue with the default behavior of the FileVisitor
            return super.visitFile(file, attrs);
        }
    }

    static class SecurityFailureException extends UnsupportedOperationException {
        public java_12061_FileScanner_A08(String message) {
            super(message);
        }
    }
}