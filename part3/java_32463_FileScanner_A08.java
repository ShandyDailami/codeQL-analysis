import java.nio.file.*;
import java.util.stream.Stream;

public class java_32463_FileScanner_A08 {

    public static void main(String[] args) {
        // Specify the directory to scan
        Path path = Paths.get(".");

        try (Stream<Path> paths = Files.walk(path, 1)) {
            // Specify the file extension to match
            paths.filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".txt"))
                .forEach(Main::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path file) {
        // Process the file here, e.g., print its name
        System.out.println("Processing file: " + file.getFileName());

        // You could also read the file contents here
        // ...
    }
}