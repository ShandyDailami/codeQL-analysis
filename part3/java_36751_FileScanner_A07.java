import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_36751_FileScanner_A07 {

    public static class FileVisitor extends SimpleFileVisitor<Path> {

        private long fileCount = 0;
        private long dirCount = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dirCount++;
            return FileVisitResult.CONTINUE;
        }

        public void printSummary() {
            System.out.println("Total files: " + fileCount);
            System.out.println("Total directories: " + dirCount);
        }
    }

    public static void main(String[] args) throws IOException {
        File root = new File(".");
        FileVisitor visitor = new FileVisitor();
        Files.walkFileTree(root.toPath(), visitor);
        visitor.printSummary();
    }
}