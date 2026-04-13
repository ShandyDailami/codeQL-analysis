import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicBoolean;

public class java_26098_FileScanner_A07 {

    private static class SecurityManager extends java.security.SecurityManager {

        private final AtomicBoolean failedAuth = new AtomicBoolean(false);

        public void authFailure() {
            failedAuth.set(true);
        }

        public boolean isFailedAuth() {
            return failedAuth.get();
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private final SecurityManager securityManager;

        public java_26098_FileScanner_A07(SecurityManager securityManager) {
            this.securityManager = securityManager;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (securityManager.isFailedAuth()) {
                System.out.println("Authentication failure detected, file: " + file.toString());
            } else {
                System.out.println("File visited successfully: " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        SecurityManager securityManager = new SecurityManager();
        MyFileVisitor fileVisitor = new MyFileVisitor(securityManager);
        Files.walkFileTree(Paths.get("/path/to/directory"), fileVisitor);
    }
}