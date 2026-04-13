import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_37248_FileScanner_A01 {
    private String directoryPath;

    public java_37248_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scan() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            processFiles(directoryStream);
        } catch (Exception e) {
            System.err.println("Error scanning directory: " + e.getMessage());
        }
    }

    private void processFiles(DirectoryStream<Path> directoryStream) {
        try (Stream<Path> stream = directoryStream) {
            stream.forEach(this::processFile);
        }
    }

    private void processFile(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println("Processing file: " + path.toString());
            // Add your security-sensitive operations here
        } else {
            System.out.println("Skipping directory: " + path.toString());
        }
    }

    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // Replace with your directory path
        FileScanner scanner = new FileScanner(directoryPath);
        scanner.scan();
    }
}