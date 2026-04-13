import java.io.File;
import java.nio.file.*;
import java.util.stream.*;

public class java_08430_FileScanner_A01 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        FileVisitor<Path> fileVisitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("Found txt file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to access file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("Visiting directory: " + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("Finished visiting directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        };

        try (FileScanner<Path> scanner = Files.newScanner(start)) {
            scanner.iterator().asParallel().forEachOrdered(fileVisitor::visitFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}