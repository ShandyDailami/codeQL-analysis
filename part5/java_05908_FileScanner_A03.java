import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_05908_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                File file = path.toFile();
                System.out.println(file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}