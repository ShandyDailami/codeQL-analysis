import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_14581_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path targetDirectory = Paths.get(".");  // Replace with the target directory
        scanDirectory(targetDirectory);
    }

    private static void scanDirectory(Path directory) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    scanDirectory(path);
                } else {
                    System.out.println(path.toString());
                }
            }
        }
    }
}