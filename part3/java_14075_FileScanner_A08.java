import java.io.IOException;
import java.nio.file.*;

public class java_14075_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                if (!Files.isWritable(path)) {
                    System.out.println("Integrity failure detected in file: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read files from directory: " + startingDirectory);
        }
    }
}