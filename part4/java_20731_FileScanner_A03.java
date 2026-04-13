import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_20731_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("C:\\Temp\\");
        scanDirectory(startingDirectory);
    }

    private static void scanDirectory(Path directory) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, "*.txt")) {
            for (Path path : directoryStream) {
                // This is a simple file scanner, not a full security-sensitive operation.
                // In a real-world scenario, you might want to use a more complex algorithm for security-sensitive operations.
                // But for this example, let's just print out the file names.
                System.out.println("Found file: " + path.toString());
           
            }
        }
    }
}