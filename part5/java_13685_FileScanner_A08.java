import java.nio.file.*;
import java.io.*;

public class java_13685_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(FileScanner::processPath);
        } catch (IOException e) {
            System.err.println("Failed to walk directory tree.");
            e.printStackTrace();
        }
    }

    private static void processPath(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(FileScanner::processLine);
        } catch (IOException e) {
            System.err.println("Failed to read file: " + path);
            e.printStackTrace();
        }
    }

    private static void processLine(String line) {
        // process line here, possibly involving integrity-related operations
    }
}