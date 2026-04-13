import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.Permission;
import java.security.PermissionCollection;

public class java_37021_FileScanner_A07 {

    static class FilePermission extends Permission {
        String name;

        public java_37021_FileScanner_A07(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public PermissionCollection getActions() {
            return null;
        }

        public boolean implies(Permission p) {
            if (p instanceof FilePermission) {
                return name.equals(((FilePermission) p).getName());
            }
            return false;
        }
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toFile().getCanonicalPath());
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        File root = new File(".");
        Files.walkFileTree(root.toPath(), new FileVisitor());
    }
}