import java.nio.file.*;
import java.util.stream.*;

public class java_36002_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.filter(Files::isRegularFile)
                .map(FileScanner::readFileContents)
                .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error reading files: " + ex.getMessage());
        }
    }

    private static String readFileContents(Path path) {
        try {
            return Files.readAllLines(path).stream().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception ex) {
            return "Error reading file: " + ex.getMessage();
        }
    }
}