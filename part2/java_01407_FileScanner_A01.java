import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_01407_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDir = Paths.get(".");

        try (Stream<Path> walk = Files.walk(startingDir)) {
            walk.forEach(FileScanner::processFile);
        } catch (IOException e) {
            System.err.println("Error walking directory tree: " + startingDir);
            e.printStackTrace();
        }
    }

    private static void processFile(Path file) {
        try {
            if (Files.isReadable(file)) {
                Files.readAllLines(file).forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file);
            e.printStackTrace();
        }
    }
}