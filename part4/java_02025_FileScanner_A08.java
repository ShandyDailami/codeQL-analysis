import java.nio.file.*;
import java.util.stream.*;

public class java_02025_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (Stream<Path> walk = Files.walk(startingDirectory)) {
            walk.forEach(Main::processPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("Directory: " + path);
        } else {
            System.out.println("File: " + path);
        }
    }
}