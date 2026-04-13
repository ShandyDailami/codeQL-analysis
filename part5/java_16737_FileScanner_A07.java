import java.io.IOException;
import java.nio.file.*;

public class java_16737_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(".");
        try (Stream<Path> paths = Files.walk(directory)) {
            paths.forEach(Main::print);
        }
        catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e.getPath());
        }
    }

    private static void print(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println(path.getFileName());
        }
    }
}