import java.io.IOException;
import java.nio.file.*;

public class java_25963_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.getFileName().toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}