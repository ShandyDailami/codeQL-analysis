import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_06152_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDir = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingDir)) {
            paths.filter(Files::isRegularFile)
                 .map(Path::toAbsolutePath)
                 .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}