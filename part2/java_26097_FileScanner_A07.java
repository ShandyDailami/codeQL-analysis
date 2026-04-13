import java.io.IOException;
import java.nio.file.*;

public class java_26097_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                System.out.println("File found: " + path.toString());
                // Perform security sensitive operation here.
            }
        }
    }
}