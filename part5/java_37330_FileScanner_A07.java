import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_37330_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.forEach(FileScanner::printFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFilePath(Path path) {
        System.out.println(path.toString());
    }
}