import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_32242_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src");

        try (Stream<Path> walk = Files.walk(startingDirectory)) {
            walk.forEach(Main::processPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("Directory: " + path);
        } else if (Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("File: " + path);
        } else {
            System.out.println("Other: " + path);
        }
    }
}