import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_21036_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        PathMatcher<? super Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<>()) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
    }
}