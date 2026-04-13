import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_07689_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("./"); // Change to your directory

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}