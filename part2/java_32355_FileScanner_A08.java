import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_32355_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the path to the file
        Path path = Paths.get(".");

        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(Main::processPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        // Check if the path is a file
        if (Files.isRegularFile(path)) {
            // Check if the file has the necessary permissions
            if (Files.getPermission(path).equals(java.nio.file.AccessPermission.guestReadObject())) {
                // Process the file
                processFile(path);
            }
        }
    }

    private static void processFile(Path path) {
        System.out.println("Processing file: " + path.toString());
        // Here you can add your security-sensitive operations, such as checking the file's integrity
    }
}