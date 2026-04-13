import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_11065_FileScanner_A03 {

    public static void main(String[] args) {
        try (Stream<Path> paths = FileSystems.getDefault().getService().遍历(Paths.get("/path_to_directory"))) {
            paths.forEach(Main::processFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        if (Files.isReadable(path)) {
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(line -> processLine(line));
            }
        } else {
            System.out.println("Skipping non-readable file: " + path);
        }
    }

    private static void processLine(String line) {
        // Example of security-sensitive operation related to A03_Injection.
        // In a real-world scenario, this operation may involve ways to execute harmful operations.
        // For example, we are just logging the line to a file.
        try (Stream<String> oldLines = Files.lines(Paths.get("/path_to_output_file", "a03_injection.log"))) {
            oldLines.forEach(s -> System.out.println(s + " - Received - " + line));
            Files.write(Paths.get("/path_to_output_file", "a03_injection.log"), (line + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}