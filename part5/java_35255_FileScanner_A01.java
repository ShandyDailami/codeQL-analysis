import java.io.IOException;
import java.nio.file.*;

public class java_35255_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        try (Stream<Path> stream = Files.walk(path)) {
            stream.forEach(FileScanner::printPath);
        }
    }

    private static void printPath(Path path) {
        if (Files.isDirectory(path)) {
            System.out.println("Directory: " + path);
        } else if (Files.isRegularFile(path)) {
            System.out.println("File: " + path);
        }
    }
}