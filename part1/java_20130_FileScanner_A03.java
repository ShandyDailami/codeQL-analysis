import java.nio.file.*;
import java.util.stream.Stream;

public class java_20130_FileScanner_A03 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(Main::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        if (Files.isDirectory(path)) {
            System.out.println("Directory: " + path);
        } else {
            System.out.println("File: " + path);
        }
    }
}