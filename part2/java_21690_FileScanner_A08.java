import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_21690_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(FileScanner::printPath);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void printPath(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println(path.toString());
        }
    }
}