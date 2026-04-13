import java.nio.file.*;
import java.util.stream.*;

public class java_15609_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> stream = Files.walk(startingDirectory)) {
            stream.filter(Files::isRegularFile)
                  .forEach(FileScanner::printFileDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileDetails(Path path) {
        if (path.toString().endsWith(".java")) {
            try (Stream<String> lines = Files.lines(path)) {
                long lineCount = lines.count();
                long maxLineLength = lines.map(String::length).max().orElse(0);
                System.out.printf("File: %s, Lines: %d, Max line length: %d%n",
                                   path.getFileName(), lineCount, maxLineLength);
            } catch (IOException e) {
                System.out.printf("Failed to read lines from %s%n", path);
            }
        }
    }
}