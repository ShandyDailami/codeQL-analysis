import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_17346_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.{txt,html}")) {
            for (Path dir : dirs) {
                if (Files.isReadable(dir)) {
                    System.out.println("Reading files in: " + dir);
                    readFiles(dir);
                } else {
                    System.err.println("Unable to read directory: " + dir);
                }
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }

    private static void readFiles(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*{.txt, .html}")) {
            for (Path file : files) {
                if (Files.isReadable(file)) {
                    System.out.println("Reading file: " + file);
                    // TODO: Process file here.
                    // For now, just print the file name.
                    System.out.println(file.getFileName());
                } else {
                    System.err.println("Unable to read file: " + file);
                }
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}