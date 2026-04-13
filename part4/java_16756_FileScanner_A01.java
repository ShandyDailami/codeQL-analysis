import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_16756_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("."); // replace with the path to the directory
        scanDirectory(dir);
    }

    private static void scanDirectory(Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    scanDirectory(path);
                } else {
                    System.out.println("File: " + path.toString());
                    // replace with the actual code for security-sensitive operations related to A01_BrokenAccessControl
                }
            }
        }
    }
}