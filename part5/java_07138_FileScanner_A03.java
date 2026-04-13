import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_07138_FileScanner_A03 {
    public static void main(String[] args) {
        Path dir = Paths.get(".");

        try (Stream<Path> paths = Files.walk(dir)) {
            paths.forEach(InjectionVulnerableFiles::checkPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkPath(Path path) {
        if (Files.isDirectory(path) && !path.toString().endsWith(".git")) {
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(InjectionVulnerableFiles::checkLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkLine(String line) {
        // Remove the comment if the line contains a comment.
        if (line.trim().startsWith("//")) return;

        // Look for injection attacks.
        if (line.contains("drop table")) {
            System.out.println("Detected injection attack: " + line);
        }
    }
}