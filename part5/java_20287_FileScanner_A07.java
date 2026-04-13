import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_20287_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();

        try (Stream<Path> stream = Files.walk(startingDirectory)) {
            stream.forEach(Main::processPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                System.out.println("Directory: " + path);
            } else if (Files.isReadable(path)) {
                System.out.println("File: " + path.getFileName());
            }
        } catch (IOException e) {
            System.err.println("Unable to access file: " + path);
        }
    }
}