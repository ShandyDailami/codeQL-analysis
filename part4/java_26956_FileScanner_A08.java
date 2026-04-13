import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_26956_FileScanner_A08 {
    private final PathMatcher<Path> matcher;

    public java_26956_FileScanner_A08(Path startingDir, String pattern) {
        this.matcher = Paths.gettingMatcher(pattern).startingFrom(startingDir);
    }

    public void scan(Path startingDir, String pattern,
            BiConsumer<Path, BasicFileAttributes> action) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDir, matcher)) {
            for (Path path : stream) {
                action.accept(path, Files.readAttributes(path, BasicFileAttributes.class));
            }
        }
    }
}