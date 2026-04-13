import java.nio.file.*;
import java.io.IOException;

public class java_09907_FileScanner_A08 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize();

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : dirStream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + e.getMessage());
        }
    }
}