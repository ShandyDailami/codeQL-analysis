import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class java_07889_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDir = new File(".");

        try {
            Files.walkFileTree(rootDir.toPath(), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            File newFile = file.toFile();

            // Here you can implement security-sensitive operations

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            File newFile = file.toFile();

            // Here you can implement security-sensitive operations

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            File newDir = dir.toFile();

            // Here you can implement security-sensitive operations

            return FileVisitResult.CONTINUE;
        }
    }
}