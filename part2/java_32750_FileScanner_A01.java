import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_32750_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.walk(start)) {
            paths.filter(FilesTest::isTxtFile)
                 .map(FilesTest::normalize)
                 .forEach(System.out::println);
        }
    }

    private static boolean isTxtFile(Path file) {
        return Files.probeContentType(file).equals("text/plain");
    }

    private static Path normalize(Path path) {
        return path.normalize().toAbsolutePath();
    }

}