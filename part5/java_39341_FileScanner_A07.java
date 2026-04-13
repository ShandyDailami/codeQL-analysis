import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_39341_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*AuthFailure*");

        Files.walkFileTree(Paths.get("/path/to/start/from"),
                new SimpleFileVisitor<>(),
                RecursiveOption.FOLLOW_LINKS);

        Files.find(Paths.get("/path/to/start/from"), 10,
                (path, basicFileAttributes) -> matcher.matches(path.toString()));
    }

    public static class SimpleFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Visited file: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Failed to visit file: " + file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}