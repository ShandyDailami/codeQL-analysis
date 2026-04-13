import java.io.IOException;
import java.nio.file.*;

public class java_13767_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("C:/");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to access the directory.");
        }
    }
}