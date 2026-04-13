import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class java_17533_FileScanner_A01 {
    private static AtomicInteger fileCount = new AtomicInteger(0);
    private static AtomicInteger dirCount = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        Files.walkFileTree(Paths.get("/path/to/start/from"), // start directory
                           attrs -> false, // callback to accept all attributes
                           recursive -> true, // recursive walk
                           FileVisitOption.FOLLOW_LINKS); // follow links

        System.out.println("Total files: " + fileCount.get());
        System.out.println("Total directories: " + dirCount.get());
    }

    public static class BasicFileVisitor extends java.nio.file.SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount.incrementAndGet();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            dirCount.incrementAndGet();
            return FileVisitResult.CONTINUE;
        }
    }
}