import java.nio.file.*;
import java.util.stream.*;

public class java_37787_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        PathMatchingStrategy<Path> strategy = Paths.get(".");
        FileVisitor<Path> visitor = FileVisitOption.FOLLOW_LINKS.equals(options) ?
                new JavaFileVisitImpl(Stream.of(Paths.get("."))) :
                new JavaFileVisitImpl(Files.newDirectoryStream(Paths.get("."), "*.java"));

        Files.walkFileTree(Paths.get("."), strategy, visitor);
    }
}

class JavaFileVisitImpl extends SimpleFileVisitor<Path> {
    private final Stream<Path> paths;

    public java_37787_FileScanner_A08(Stream<Path> paths) {
        this.paths = paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".java")) {
            paths.forEach(System.out::println);
        }
        return FileVisitResult.CONTINUE;
    }
}