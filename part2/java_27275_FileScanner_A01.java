import java.io.File;
import java.io.IOException;
import java.io.FilePermission;
import java.io.FileVisitor;
import java.io.IOExceptionPermission;
import java.security.Permission;

public class java_27275_FileScanner_A01 implements FileVisitor<File> {
    private final FilePermission permission;

    public java_27275_FileScanner_A01(FilePermission permission) {
        this.permission = permission;
    }

    @Override
    public FileVisitResult preVisitDirectory(File dir, BasicFileAttributes attrs) throws IOException {
        if (!dir.getCanonicalFile().getParent().equals(dir.getCanonicalFile().toString())) {
            throw new SecurityException("Directory traversal attack detected");
        }
        if (!dir.getCanonicalFile().hasPermission(permission)) {
            System.out.println("Access to " + dir + " is blocked");
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(File file, BasicFileAttributes attrs) throws IOException {
        if (!file.hasPermission(permission)) {
            System.out.println("Access to " + file + " is blocked");
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(File file, IOException exc) throws IOException {
        System.err.println(file + ": " + exc);
        return FileVisitResult.CONTINUE;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        FilePermissionScanner scanner = new FilePermissionScanner(new FilePermission.GroupActionPermission("group", "read"));
        Files.walkFileTree(Paths.get("/path/to/directory"), scanner);
    }
}