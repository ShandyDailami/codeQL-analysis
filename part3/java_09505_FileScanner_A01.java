import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_09505_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*");

        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().startsWith(".") || matcher.matches(file.getFileName()))
                    return FileVisitResult.CONTINUE;

                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}