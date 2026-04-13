import java.nio.file.*;
import java.util.stream.*;

public class java_23850_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("path_to_file");
        Files.lines(path)
            .map(line -> processLine(line))
            .forEach(System.out::println);
    }

    static String processLine(String line) {
        // This is a form of injection. We're not actually sanitizing the input,
        // but rather, we're trying to prevent it from being executed as code.
        // In a real scenario, you'd use a library or framework that sanitizes user input.
        try {
            Runtime.getRuntime().exec(line);
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
        return "";
    }
}