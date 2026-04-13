import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_38075_FileScanner_A01 {

    public static void main(String[] args) {
        Path path = Paths.get("."); // the current directory

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inner class to implement FileVisitor
    private static class SimpleFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}