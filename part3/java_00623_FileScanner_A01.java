import java.io.IOException;
import java.nio.file.*;

public class java_00623_FileScanner_A01 {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.newDirectoryStream(start)) {
            for (Path path : paths) {
                if (Files.isDirectory(path)) {
                    printDirectoryContents(path);
                }
            }
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }

    private static void printDirectoryContents(Path dir) {
        System.out.printf("Directory: %s%n", dir);

        try (Stream<Path> entries = Files.newDirectoryStream(dir)) {
            for (Path entry : entries) {
                if (Files.isDirectory(entry)) {
                    System.out.printf("Directory: %s%n", entry);
                } else {
                    System.out.printf("File: %s%n", entry);
                }
            }
        } catch (IOException ex) {
            System.err.printf("I/O error: %s%n", ex);
        }
    }
}