import java.nio.file.*;
import java.util.stream.*;

public class java_19206_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        Path path = Paths.get(directory);

        try (Stream<Path> paths = Files.newDirectoryStream(path)) {
            paths.forEach(FileScannerExample::processFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        String fileName = path.getFileName().toString();
        System.out.println("Processing file: " + fileName);

        // This is a simple example of security-sensitive operation.
        // In a real-world application, you should never print file contents directly.
        // The following is a placeholder operation.
        System.out.println("File contents: " + readFileContents(path));
    }

    private static String readFileContents(Path path) {
        try {
            return Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}