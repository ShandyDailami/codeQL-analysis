import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.Permission;
import java.security.SecurityManager;

public class java_27103_FileScanner_A07 {

    private SecurityManager securityManager;

    public java_27103_FileScanner_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void scanDirectory(String directoryPath) {
        File rootDirectory = new File(directoryPath);

        if (!rootDirectory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!securityManager.checkPermission(new FilePermission("."))) {
            System.out.println("Insufficient permissions to access files in directory");
            return;
        }

        try {
            FileVisitor fileVisitor = new FileVisitor() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!securityManager.checkPermission(new FilePermission(dir.toString()))) {
                        return FileVisitResult.REJECTED;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!securityManager.checkPermission(new FilePermission(file.toString()))) {
                        System.out.println("Insufficient permissions to access file: " + file);
                        return FileVisitResult.REJECTED;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitLink(Path link, BasicFileAttributes attrs) throws IOException {
                    if (!securityManager.checkPermission(new FilePermission(link.toString()))) {
                        System.out.println("Insufficient permissions to access link: " + link);
                        return FileVisitResult.REJECTED;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!securityManager.checkPermission(new FilePermission(dir.toString()))) {
                        System.out.println("Insufficient permissions to access directory: " + dir);
                    }
                    return FileVisitResult.CONTINUE;
                }
            };

            java.nio.file.Files.walkFileTree(rootDirectory.toPath(), fileVisitor);
        } catch (SecurityException e) {
            System.out.println("Security exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public boolean checkPermission(Permission perm) {
                return false;
            }

            @Override
            public boolean checkPermission(Permission perm, Object obj) {
                return false;
            }

            @Override
            public void checkAccess(SourceFile file, Linkage lnk) {
                throw new SecurityException("Access denied");
            }
        };

        SecureFileScanner scanner = new SecureFileScanner(securityManager);
        scanner.scanDirectory("/path/to/directory");
    }
}