import java.nio.file.*;
import java.util.stream.*;

public class java_15881_FileScanner_A03 {
    public static void main(String[] args) {
        Path dir = Paths.get("path_to_directory");

        try (Stream<Path> paths = Files.walk(dir)) {
            paths
                .filter(Files::isRegularFile)
                .filter(Main::isFileSafe)
                .forEach(Main::readFile);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static boolean isFileSafe(Path path) {
        // Here you can implement your own security-sensitive operations
        // For example, checking if the file contains a certain string or not
        // Return true if the file is safe, false otherwise
    }

    private static void readFile(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error reading file: " + path.toString() + ", error: " + ex.getMessage());
        }
    }
}