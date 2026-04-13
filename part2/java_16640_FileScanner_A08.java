import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_16640_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("."); // start from the current directory
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Unable to access: " + file);
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(start, fileVisitor);
    }
}