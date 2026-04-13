import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_32429_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, path -> path.toString().endsWith(".txt"))) {
            for (Path path : directoryStream) {
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}