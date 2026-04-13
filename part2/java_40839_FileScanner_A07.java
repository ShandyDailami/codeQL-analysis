import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_40839_FileScanner_A07 {
    public static void main(String[] args) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."))) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.getFileName().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}