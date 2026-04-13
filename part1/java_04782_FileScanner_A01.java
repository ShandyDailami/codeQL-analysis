import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_04782_FileScanner_A01 {

    private static class FileVisitorImpl extends FileVisitor<Path> {

        private int fileCount = 0;
        private int dirCount = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("Pre-visit directory: " + dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Visit file: " + file);
            fileCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("Post-visit directory: " + dir);
            dirCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Visit file failed: " + file);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        FileVisitorImpl fileVisitor = new FileVisitorImpl();
        try {
            Files.walkFileTree(Paths.get("."), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total file count: " + fileVisitor.fileCount);
        System.out.println("Total directory count: " + fileVisitor.dirCount);
    }
}