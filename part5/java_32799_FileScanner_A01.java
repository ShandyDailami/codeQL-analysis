import java.io.IOException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileVisitor;
import java.io.Serializable;

public class java_32799_FileScanner_A01 implements FileVisitor<Path>, Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            File file = new File(".");
            new LegacyFileScanner().visit(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toString());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toString());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public void endTraversal(Path dir) throws IOException, SecurityException {
        // no-op
    }

    public IOException reorganize(Path oldRoot, Path newRoot) throws IOException, SecurityException {
        // no-op
        return null;
    }
}