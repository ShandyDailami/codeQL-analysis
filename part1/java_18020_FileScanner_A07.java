import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_18020_FileScanner_A07 {
    private static final PathMatcher<Path> FILE_EXP = PathMatcher.literal("fexists");
    private static final PathMatcher<Path> DIR_EXP = PathMatcher.literal("dexists");

    private static boolean isDirectorySecure(Path dir) throws IOException {
        return DIR_EXP.matches(dir);
    }

    private static boolean isFileSecure(Path file) throws IOException {
        return FILE_EXP.matches(file);
    }

    private static boolean isReadableSecure(Path file) throws IOException {
        return Files.isReadable(file);
    }

    public static void main(String... args) throws Exception {
        Path startingPath = Paths.get(".").toAbsolutePath();
        try (Stream<Path> stream = Files.find(startingPath, 1, (p, attrs) -> isFileSecure(p) && !isDirectorySecure(p))) {
            stream.forEach(System.out::println);
        }
    }
}