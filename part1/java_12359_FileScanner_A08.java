import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardVisitResult;

public class java_12359_FileScanner_A08 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        FileVisitor fileVisitor = new FileVisitorImpl();
        try {
            Files.walkFileTree(rootDirectory.toPath(), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileVisitorImpl extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Visited: " + file.toAbsolutePath());
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Failed to visit: " + file.toAbsolutePath());
            return super.visitFileFailed(file, exc);
        }
    }
}