import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_08416_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // this will be the directory we want to scan
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(VanillaFileScanner::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}