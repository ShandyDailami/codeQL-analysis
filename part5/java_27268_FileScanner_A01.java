import java.io.IOException;
import java.nio.file.*;

public class java_27268_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src/main/resources");

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirStream) {
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}