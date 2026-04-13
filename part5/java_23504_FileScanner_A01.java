import java.io.IOException;
import java.nio.file.*;

public class java_23504_FileScanner_A01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDir = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDir, "*.java")) {
            for (Path dir : dirs) {
                System.out.println("Found directory: " + dir.toString());
                try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.java")) {
                    for (Path file : files) {
                        System.out.println("Found file: " + file.toString());
                    }
                }
            }
        }
    }
}