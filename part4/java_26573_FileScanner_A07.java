import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_26573_FileScanner_A07 {
    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:A07_AuthFailure*");
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Found file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}