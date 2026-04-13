import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;

public class java_24257_FileScanner_A01 {

    private static final Pattern<File> WRITEABLE_PATTERN = Pattern.compile("^(?![.]).+");
    private static final PathMatcher<Path> WRITEABLE_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*");

    public static void main(String[] args) throws IOException, InterruptedException {
        Path dir = FileSystems.getDefault().getPath(".");

        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (WRITEABLE_MATCHER.matches(file.getFileName())) {
                    System.out.println("Trying to access: " + file);
                    Files.readAllBytes(file);
                    System.out.println("Access granted for: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}