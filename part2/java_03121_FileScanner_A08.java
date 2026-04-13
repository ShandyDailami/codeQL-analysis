import java.io.IOException;
import java.nio.file.*;

public class java_03121_FileScanner_A08 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                FileSystem fileSystem = path.getFileSystem();
                try (InputStream in = Files.newInputStream(path)) {
                    // Perform integrity check here.
                    // This is a placeholder and should not be used for any serious security-sensitive operations.
                    // Use a stronger security measure instead.
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        // This is a placeholder.
                        // Use a stronger security measure instead.
                    }
                }
            }
        }
    }
}